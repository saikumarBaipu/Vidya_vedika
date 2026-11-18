package com.vidyavedika.learning_service.controller;

import com.vidyavedika.learning_service.dto.*;
import com.vidyavedika.learning_service.entity.*;
import com.vidyavedika.learning_service.service.LearningService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/api/learning")
public class LearningController {
	private final LearningService s;

	public LearningController(LearningService s) {
		this.s = s;
	}

	@GetMapping("/languages/{languageId}/lessons")
	public List<Lesson> lessons(@PathVariable Long languageId) {
		return s.lessons(languageId);
	}

	@PostMapping("/lessons")
	public Lesson createLesson(@Valid @RequestBody LessonRequest r) {
		return s.createLesson(r);
	}

	@GetMapping("/lessons/{lessonId}/vocabulary")
	public List<Vocabulary> vocabulary(@PathVariable Long lessonId) {
		return s.vocabulary(lessonId);
	}

	@PostMapping("/vocabulary")
	public Vocabulary vocabulary(@Valid @RequestBody VocabularyRequest r) {
		return s.addVocabulary(r);
	}

	@PostMapping("/progress")
	public UserLessonProgress progress(@Valid @RequestBody ProgressRequest r) {
		return s.saveProgress(r);
	}

	@GetMapping("/progress/{userId}")
	public List<UserLessonProgress> progress(@PathVariable Long userId) {
		return s.progress(userId);
	}

	@GetMapping("/daily")
	public List<DailyTask> daily(@RequestParam(defaultValue = "") String date) {
		return s.daily(date.isBlank() ? LocalDate.now() : LocalDate.parse(date));
	}

	@PostMapping("/daily")
	public DailyTask addTask(@Valid @RequestBody DailyTaskRequest r) {
		return s.addTask(r);
	}
}
