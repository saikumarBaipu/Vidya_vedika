package com.vidyavedika.learning_service.dto;

import jakarta.validation.constraints.*;

public record VocabularyRequest(@NotNull Long lessonId, @NotBlank @Size(max = 120) String word,
		@NotBlank @Size(max = 500) String meaning, @Size(max = 500) String exampleSentence,
		@Size(max = 200) String pronunciation) {
}
