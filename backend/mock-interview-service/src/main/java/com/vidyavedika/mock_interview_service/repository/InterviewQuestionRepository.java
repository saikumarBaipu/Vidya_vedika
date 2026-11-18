package com.vidyavedika.mock_interview_service.repository;

import com.vidyavedika.mock_interview_service.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {
}