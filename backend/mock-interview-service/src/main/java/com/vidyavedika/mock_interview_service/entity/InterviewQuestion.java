package com.vidyavedika.mock_interview_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interview_questions")
public class InterviewQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String category;
	String difficulty;
	@Column(length = 2000)
	String question;

	public Long getId() {
		return id;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String v) {
		question = v;
	}
}