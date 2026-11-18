package com.vidyavedika.payment_service.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "contributions")
public class Contribution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long userId;
	double amount;
	String status;
	String reference;
	LocalDateTime createdAt;

	@PrePersist
	void init() {
		createdAt = LocalDateTime.now();
		if (status == null)
			status = "RECEIVED";
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double v) {
		amount = v;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String v) {
		status = v;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String v) {
		reference = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
