package com.vidyavedika.mock_interview_service.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "interview_sessions")
public class InterviewSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(nullable = false)
	Long userId;
	String category;
	String difficulty;
	String status;
	double score;
	LocalDateTime startedAt, completedAt;

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long v) {
		userId = v;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String v) {
		category = v;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String v) {
		difficulty = v;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String v) {
		status = v;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double v) {
		score = v;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime v) {
		startedAt = v;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime v) {
		completedAt = v;
	}
}
