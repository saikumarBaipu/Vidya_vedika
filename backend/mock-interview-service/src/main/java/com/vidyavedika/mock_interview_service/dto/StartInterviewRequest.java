package com.vidyavedika.mock_interview_service.dto;

import jakarta.validation.constraints.*;

public record StartInterviewRequest(@NotNull Long userId, @NotBlank String category, @NotBlank String difficulty) {
}
