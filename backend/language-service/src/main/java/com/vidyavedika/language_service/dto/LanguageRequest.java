package com.vidyavedika.language_service.dto;

import jakarta.validation.constraints.*;

public record LanguageRequest(@NotBlank @Size(max = 80) String name, @NotBlank @Size(max = 10) String code,
		String description, String iconUrl, boolean active) {
}
