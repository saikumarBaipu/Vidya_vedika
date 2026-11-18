package com.vidyavedika.learning_service.repository;

import com.vidyavedika.learning_service.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
	List<Lesson> findByLanguageIdOrderByOrderIndexAsc(Long languageId);
}