package com.vidyavedika.learning_service.repository;

import com.vidyavedika.learning_service.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
	List<Vocabulary> findByLessonId(Long lessonId);
}
