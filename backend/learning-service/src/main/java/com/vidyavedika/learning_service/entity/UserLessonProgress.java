package com.vidyavedika.learning_service.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "user_lesson_progress", uniqueConstraints = @UniqueConstraint(name = "uk_user_lesson", columnNames = {
		"user_id", "lesson_id" }))
public class UserLessonProgress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "user_id", nullable = false)
	Long userId;
	@Column(name = "lesson_id", nullable = false)
	Long lessonId;
	int percent;
	long timeSpentSeconds;
	LocalDateTime updatedAt;

	@PrePersist
	@PreUpdate
	void touch() {
		updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long v) {
		userId = v;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long v) {
		lessonId = v;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int v) {
		percent = v;
	}

	public long getTimeSpentSeconds() {
		return timeSpentSeconds;
	}

	public void setTimeSpentSeconds(long v) {
		timeSpentSeconds = v;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}
