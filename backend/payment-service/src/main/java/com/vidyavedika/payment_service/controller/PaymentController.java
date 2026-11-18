package com.vidyavedika.payment_service.controller;

import com.vidyavedika.payment_service.dto.*;
import com.vidyavedika.payment_service.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	private final PaymentService s;

	public PaymentController(PaymentService s) {
		this.s = s;
	}

	@PostMapping("/contributions")
	public Object contribute(@Valid @RequestBody ContributionRequest r) {
		return s.contribute(r);
	}

	@GetMapping("/contributions/{userId}")
	public Object history(@PathVariable Long userId) {
		return s.history(userId);
	}

	@GetMapping("/summary")
	public Map<String, Object> summary() {
		return Map.of("totalContributions", s.total(), "optional", true);
	}

	@GetMapping("/info")
	public Map<String, String> info() {
		return Map.of("upiId", System.getenv().getOrDefault("PAYMENT_UPI_ID", "configure-me"));
	}
}
