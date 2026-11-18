package com.vidyavedika.user_service.dto;

import jakarta.validation.constraints.*;

public record UserProfileDto(@NotBlank @Size(max = 100) String displayName, String preferredLanguage,
		String learningLevel, String learningGoals, @Min(5) @Max(180) Integer dailyPracticeTarget,
		String profilePhotoUrl) {
}
