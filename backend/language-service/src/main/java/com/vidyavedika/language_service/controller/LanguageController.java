package com.vidyavedika.language_service.controller;

import com.vidyavedika.language_service.dto.LanguageRequest;
import com.vidyavedika.language_service.entity.Language;
import com.vidyavedika.language_service.service.LanguageService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private final LanguageService service;

	public LanguageController(LanguageService s) {
		service = s;
	}

	@GetMapping
	public Page<Language> all(@RequestParam(required = false) String q, Pageable pageable) {
		return service.find(q, pageable);
	}

	@GetMapping("/{id}")
	public Language one(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public Language create(@Valid @RequestBody LanguageRequest d) {
		return service.create(d);
	}

	@PutMapping("/{id}")
	public Language update(@PathVariable Long id, @Valid @RequestBody LanguageRequest d) {
		return service.update(id, d);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
