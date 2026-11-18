package com.vidyavedika.learning_service.dto;

import jakarta.validation.constraints.*;

public record ProgressRequest(@NotNull Long userId, @NotNull Long lessonId, @Min(0) @Max(100) int percent,
		@Min(0) long timeSpentSeconds) {
}
