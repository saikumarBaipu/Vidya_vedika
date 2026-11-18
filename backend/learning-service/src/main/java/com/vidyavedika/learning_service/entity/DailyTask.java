package com.vidyavedika.learning_service.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "daily_tasks", indexes = @Index(name = "idx_daily_date", columnList = "task_date"))
public class DailyTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(nullable = false)
	String title;
	@Column(nullable = false)
	String taskType;
	int target;
	@Column(name = "task_date", nullable = false)
	LocalDate taskDate;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String v) {
		title = v;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String v) {
		taskType = v;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int v) {
		target = v;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate v) {
		taskDate = v;
	}
}
