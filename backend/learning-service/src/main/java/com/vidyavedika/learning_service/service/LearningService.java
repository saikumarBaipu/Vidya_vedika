package com.vidyavedika.learning_service.service;

import com.vidyavedika.learning_service.dto.*;
import com.vidyavedika.learning_service.entity.*;
import com.vidyavedika.learning_service.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.util.*;

@Service
public class LearningService {
	private final LessonRepository lessons;
	private final VocabularyRepository vocab;
	private final UserLessonProgressRepository progress;
	private final DailyTaskRepository tasks;

	public LearningService(LessonRepository l, VocabularyRepository v, UserLessonProgressRepository p,
			DailyTaskRepository t) {
		lessons = l;
		vocab = v;
		progress = p;
		tasks = t;
	}

	@Transactional
	public Lesson createLesson(LessonRequest r) {
		Lesson x = new Lesson();
		x.setLanguageId(r.languageId());
		x.setTitle(r.title());
		x.setLevel(r.level());
		x.setOrderIndex(r.orderIndex());
		return lessons.save(x);
	}

	public List<Lesson> lessons(Long languageId) {
		return lessons.findByLanguageIdOrderByOrderIndexAsc(languageId);
	}

	@Transactional
	public Vocabulary addVocabulary(VocabularyRequest r) {
		Vocabulary x = new Vocabulary();
		x.setLessonId(r.lessonId());
		x.setWord(r.word());
		x.setMeaning(r.meaning());
		x.setExampleSentence(r.exampleSentence());
		x.setPronunciation(r.pronunciation());
		return vocab.save(x);
	}

	public List<Vocabulary> vocabulary(Long lessonId) {
		return vocab.findByLessonId(lessonId);
	}

	@Transactional
	public UserLessonProgress saveProgress(ProgressRequest r) {
		UserLessonProgress x = progress.findByUserIdAndLessonId(r.userId(), r.lessonId())
				.orElseGet(UserLessonProgress::new);
		x.setUserId(r.userId());
		x.setLessonId(r.lessonId());
		x.setPercent(r.percent());
		x.setTimeSpentSeconds(x.getTimeSpentSeconds() + r.timeSpentSeconds());
		return progress.save(x);
	}

	public List<UserLessonProgress> progress(Long userId) {
		return progress.findByUserId(userId);
	}

	@Transactional
	public DailyTask addTask(DailyTaskRequest r) {
		DailyTask x = new DailyTask();
		x.setTitle(r.title());
		x.setTaskType(r.taskType());
		x.setTarget(r.target());
		x.setTaskDate(r.taskDate());
		return tasks.save(x);
	}

	public List<DailyTask> daily(LocalDate date) {
		return tasks.findByTaskDateOrderByIdAsc(date);
	}
}
