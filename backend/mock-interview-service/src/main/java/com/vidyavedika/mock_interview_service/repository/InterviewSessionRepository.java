package com.vidyavedika.mock_interview_service.repository;

import com.vidyavedika.mock_interview_service.entity.InterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {
	List<InterviewSession> findByUserIdOrderByStartedAtDesc(Long userId);
}
