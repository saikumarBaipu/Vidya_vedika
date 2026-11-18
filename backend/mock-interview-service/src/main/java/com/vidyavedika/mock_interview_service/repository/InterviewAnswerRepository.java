package com.vidyavedika.mock_interview_service.repository;

import com.vidyavedika.mock_interview_service.entity.InterviewAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface InterviewAnswerRepository extends JpaRepository<InterviewAnswer, Long> {
	List<InterviewAnswer> findBySessionId(Long sessionId);
}
