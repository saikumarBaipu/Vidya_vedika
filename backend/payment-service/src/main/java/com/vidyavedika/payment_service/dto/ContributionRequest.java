package com.vidyavedika.payment_service.dto;

import jakarta.validation.constraints.*;

public record ContributionRequest(@NotNull Long userId, @Positive double amount, @Size(max = 100) String reference) {
}
