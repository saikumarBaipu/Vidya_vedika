package com.vidyavedika.learning_service.dto;

import jakarta.validation.constraints.*;

public record LessonRequest(@NotNull Long languageId, @NotBlank @Size(max = 160) String title, @NotBlank String level,
		@Min(0) int orderIndex) {
}
