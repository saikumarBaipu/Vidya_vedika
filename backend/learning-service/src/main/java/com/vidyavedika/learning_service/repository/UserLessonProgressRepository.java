package com.vidyavedika.learning_service.repository;

import com.vidyavedika.learning_service.entity.UserLessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserLessonProgressRepository extends JpaRepository<UserLessonProgress, Long> {
	Optional<UserLessonProgress> findByUserIdAndLessonId(Long userId, Long lessonId);

	List<UserLessonProgress> findByUserId(Long userId);
}
