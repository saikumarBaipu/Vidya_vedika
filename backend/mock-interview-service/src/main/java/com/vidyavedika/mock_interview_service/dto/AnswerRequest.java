package com.vidyavedika.mock_interview_service.dto;

import jakarta.validation.constraints.*;

public record AnswerRequest(@NotNull Long questionId, @NotBlank @Size(max = 5000) String answer) {
}
