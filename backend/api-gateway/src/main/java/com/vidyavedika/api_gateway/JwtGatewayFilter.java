package com.vidyavedika.api_gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtGatewayFilter implements GlobalFilter, Ordered {
	private final SecretKey key;

	public JwtGatewayFilter(@Value("${jwt.secret}") String secret) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String path = exchange.getRequest().getURI().getPath();
		if (path.startsWith("/api/auth/") || path.equals("/actuator/health"))
			return chain.filter(exchange);

		String header = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if (header == null || !header.startsWith("Bearer "))
			return unauthorized(exchange);
		try {
			Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(header.substring(7)).getPayload();
			String role = claims.get("role", String.class);
			if (path.startsWith("/api/admin/") && !"ADMIN".equals(role))
				return forbidden(exchange);
			ServerWebExchange mutated = exchange.mutate().request(r -> r.headers(h -> {
				h.remove("X-User-Id");
				h.remove("X-User-Email");
				h.remove("X-User-Role");
				h.set("X-User-Id", String.valueOf(claims.get("userId")));
				h.set("X-User-Email", claims.getSubject());
				h.set("X-User-Role", role);
			})).build();
			return chain.filter(mutated);
		} catch (Exception ex) {
			return unauthorized(exchange);
		}
	}

	private Mono<Void> unauthorized(ServerWebExchange e) {
		e.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		return e.getResponse().setComplete();
	}

	private Mono<Void> forbidden(ServerWebExchange e) {
		e.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
		return e.getResponse().setComplete();
	}

	@Override
	public int getOrder() {
		return -100;
	}
}
