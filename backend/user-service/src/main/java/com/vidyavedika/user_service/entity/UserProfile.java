package com.vidyavedika.user_service.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
	@Id
	private Long userId;
	@Column(nullable = false)
	private String displayName;
	private String preferredLanguage;
	private String learningLevel;
	private String learningGoals;
	private Integer dailyPracticeTarget = 15;
	private String profilePhotoUrl;
	@Column(nullable = false)
	private Instant createdAt = Instant.now();
	@Column(nullable = false)
	private Instant updatedAt = Instant.now();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long v) {
		userId = v;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String v) {
		displayName = v;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String v) {
		preferredLanguage = v;
	}

	public String getLearningLevel() {
		return learningLevel;
	}

	public void setLearningLevel(String v) {
		learningLevel = v;
	}

	public String getLearningGoals() {
		return learningGoals;
	}

	public void setLearningGoals(String v) {
		learningGoals = v;
	}

	public Integer getDailyPracticeTarget() {
		return dailyPracticeTarget;
	}

	public void setDailyPracticeTarget(Integer v) {
		dailyPracticeTarget = v;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public void setProfilePhotoUrl(String v) {
		profilePhotoUrl = v;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	void touch() {
		updatedAt = Instant.now();
	}
}
