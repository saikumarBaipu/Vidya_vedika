package com.vidyavedika.notification_service.dto;

import jakarta.validation.constraints.*;

public record NotificationRequest(@NotNull Long userId, @NotBlank String title,
		@NotBlank @Size(max = 2000) String message) {
}
