package com.vidyavedika.user_service.controller;

import com.vidyavedika.user_service.dto.UserProfileDto;
import com.vidyavedika.user_service.entity.UserProfile;
import com.vidyavedika.user_service.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserProfileService service;

	public UserController(UserProfileService s) {
		service = s;
	}

	@GetMapping("/me")
	public UserProfile me(@RequestHeader("X-User-Id") Long id,
			@RequestHeader(value = "X-User-Name", required = false) String name) {
		return service.get(id, name);
	}

	@PutMapping("/me")
	public UserProfile update(@RequestHeader("X-User-Id") Long id, @Valid @RequestBody UserProfileDto dto) {
		return service.update(id, dto);
	}
}
