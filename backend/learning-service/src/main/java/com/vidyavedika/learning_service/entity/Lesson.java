package com.vidyavedika.learning_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(nullable = false)
	Long languageId;
	@Column(nullable = false)
	String title;
	String level;
	int orderIndex;

	public Long getId() {
		return id;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long v) {
		languageId = v;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String v) {
		title = v;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String v) {
		level = v;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int v) {
		orderIndex = v;
	}
}