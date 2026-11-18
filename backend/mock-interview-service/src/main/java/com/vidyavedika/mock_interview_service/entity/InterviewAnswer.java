package com.vidyavedika.mock_interview_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interview_answers")
public class InterviewAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long sessionId;
	Long questionId;
	@Column(length = 5000)
	String answer;
	double score;

	public Long getId() {
		return id;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long v) {
		sessionId = v;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long v) {
		questionId = v;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String v) {
		answer = v;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double v) {
		score = v;
	}
}
