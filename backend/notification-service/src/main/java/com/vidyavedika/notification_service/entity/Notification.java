package com.vidyavedika.notification_service.entity;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long userId;
	String title;
	@Column(length = 2000)
	String message;
	boolean readFlag;
	LocalDateTime createdAt;

	@PrePersist
	void init() {
		createdAt = LocalDateTime.now();
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String v) {
		title = v;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String v) {
		message = v;
	}

	public boolean isReadFlag() {
		return readFlag;
	}

	public void setReadFlag(boolean v) {
		readFlag = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
