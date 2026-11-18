package com.vidyavedika.notification_service.controller;

import com.vidyavedika.notification_service.dto.*;
import com.vidyavedika.notification_service.service.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	private final NotificationService s;

	public NotificationController(NotificationService s) {
		this.s = s;
	}

	@GetMapping("/{userId}")
	public Object list(@PathVariable Long userId) {
		return s.list(userId);
	}

	@PostMapping
	public Object send(@Valid @RequestBody NotificationRequest r) {
		return s.send(r);
	}

	@PostMapping("/{id}/read")
	public Object read(@PathVariable Long id) {
		return s.markRead(id);
	}
}
