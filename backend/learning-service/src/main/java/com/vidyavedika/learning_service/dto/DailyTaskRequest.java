package com.vidyavedika.learning_service.dto;

import jakarta.validation.constraints.*;

public record DailyTaskRequest(@NotBlank String title, @NotBlank String taskType, @Min(1) @Max(100) int target,
		@NotNull java.time.LocalDate taskDate) {
}
