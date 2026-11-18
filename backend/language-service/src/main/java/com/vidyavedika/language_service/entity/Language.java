package com.vidyavedika.language_service.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false, unique = true)
	private String code;
	private String description;
	private String iconUrl;
	@Column(nullable = false)
	private boolean active = true;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String v) {
		name = v;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String v) {
		code = v;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String v) {
		description = v;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String v) {
		iconUrl = v;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean v) {
		active = v;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
}
