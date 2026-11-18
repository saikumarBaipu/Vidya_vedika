package com.vidyavedika.notification_service.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	ResponseEntity<Map<String, Object>> bad(IllegalArgumentException e) {
		return ResponseEntity.badRequest().body(Map.of("timestamp", Instant.now(), "status", 400, "error",
				"BAD_REQUEST", "message", e.getMessage() == null ? "Invalid request" : e.getMessage()));
	}

	@ExceptionHandler(NoSuchElementException.class)
	ResponseEntity<Map<String, Object>> notFound(NoSuchElementException e) {
		return ResponseEntity.status(404).body(Map.of("timestamp", Instant.now(), "status", 404, "error", "NOT_FOUND",
				"message", "Resource not found"));
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<Map<String, Object>> server(Exception e) {
		return ResponseEntity.status(500).body(Map.of("timestamp", Instant.now(), "status", 500, "error",
				"INTERNAL_SERVER_ERROR", "message", "Unexpected server error"));
	}
}
