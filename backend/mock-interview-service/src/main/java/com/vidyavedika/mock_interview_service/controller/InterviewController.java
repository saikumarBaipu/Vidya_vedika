package com.vidyavedika.mock_interview_service.controller;

import com.vidyavedika.mock_interview_service.dto.*;
import com.vidyavedika.mock_interview_service.entity.*;
import com.vidyavedika.mock_interview_service.service.InterviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
	private final InterviewService s;

	public InterviewController(InterviewService s) {
		this.s = s;
	}

	@PostMapping("/start")
	public InterviewSession start(@Valid @RequestBody StartInterviewRequest r) {
		return s.start(r);
	}

	@PostMapping("/{id}/answer")
	public InterviewAnswer answer(@PathVariable Long id, @Valid @RequestBody AnswerRequest r) {
		return s.answer(id, r);
	}

	@PostMapping("/{id}/complete")
	public InterviewSession complete(@PathVariable Long id) {
		return s.complete(id);
	}

	@GetMapping("/questions")
	public List<InterviewQuestion> questions() {
		return s.questions();
	}

	@GetMapping("/history/{userId}")
	public List<InterviewSession> history(@PathVariable Long userId) {
		return s.history(userId);
	}
}
