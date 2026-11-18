package com.vidyavedika.mock_interview_service.service;
import com.vidyavedika.mock_interview_service.dto.*; import com.vidyavedika.mock_interview_service.entity.*; import com.vidyavedika.mock_interview_service.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.time.*; import java.util.*;
@Service public class InterviewService {
 private final InterviewSessionRepository sessions; private final InterviewAnswerRepository answers; private final InterviewQuestionRepository questions;
 public InterviewService(InterviewSessionRepository s,InterviewAnswerRepository a,InterviewQuestionRepository q){sessions=s;answers=a;questions=q;}
 @Transactional public InterviewSession start(StartInterviewRequest r){InterviewSession x=new InterviewSession();x.setUserId(r.userId());x.setCategory(r.category());x.setDifficulty(r.difficulty());x.setStatus("IN_PROGRESS");x.setScore(0);x.setStartedAt(LocalDateTime.now());return sessions.save(x);}
 @Transactional public InterviewAnswer answer(Long sessionId,AnswerRequest r){if(!sessions.existsById(sessionId))throw new NoSuchElementException("Interview session not found");InterviewAnswer a=new InterviewAnswer();a.setSessionId(sessionId);a.setQuestionId(r.questionId());a.setAnswer(r.answer());a.setScore(score(r.answer()));return answers.save(a);}
 private double score(String a){String x=a.trim(); if(x.length()<10)return 30; if(x.length()<40)return 60; if(x.length()<100)return 80; return 90;}
 @Transactional public InterviewSession complete(Long id){InterviewSession s=sessions.findById(id).orElseThrow(()->new NoSuchElementException("Interview session not found"));List<InterviewAnswer>a=answers.findBySessionId(id);s.setScore(a.stream().mapToDouble(InterviewAnswer::getScore).average().orElse(0));s.setStatus("COMPLETED");s.setCompletedAt(LocalDateTime.now());return sessions.save(s);}
 public List<InterviewQuestion> questions(){return questions.findAll();} public List<InterviewSession> history(Long userId){return sessions.findByUserIdOrderByStartedAtDesc(userId);}
}
