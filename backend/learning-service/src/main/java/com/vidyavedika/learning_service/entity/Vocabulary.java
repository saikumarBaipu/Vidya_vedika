package com.vidyavedika.learning_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vocabulary", indexes = @Index(name = "idx_vocab_lesson", columnList = "lesson_id"))
public class Vocabulary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "lesson_id", nullable = false)
	Long lessonId;
	@Column(nullable = false, length = 120)
	String word;
	@Column(nullable = false, length = 500)
	String meaning;
	@Column(length = 500)
	String exampleSentence;
	@Column(length = 200)
	String pronunciation;

	public Long getId() {
		return id;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long v) {
		lessonId = v;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String v) {
		word = v;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String v) {
		meaning = v;
	}

	public String getExampleSentence() {
		return exampleSentence;
	}

	public void setExampleSentence(String v) {
		exampleSentence = v;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String v) {
		pronunciation = v;
	}
}
