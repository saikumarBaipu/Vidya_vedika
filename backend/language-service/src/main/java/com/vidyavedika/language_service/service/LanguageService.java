package com.vidyavedika.language_service.service;

import com.vidyavedika.language_service.entity.Language;
import com.vidyavedika.language_service.repository.LanguageRepository;
import com.vidyavedika.language_service.dto.LanguageRequest;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanguageService {
	private final LanguageRepository repo;

	public LanguageService(LanguageRepository r) {
		repo = r;
	}

	public Page<Language> find(String q, Pageable p) {
		return q == null || q.isBlank() ? repo.findAll(p) : repo.findByNameContainingIgnoreCaseAndActiveTrue(q, p);
	}

	public Language get(Long id) {
		return repo.findById(id).orElseThrow();
	}

	@Transactional
	public Language create(LanguageRequest d) {
		Language l = new Language();
		l.setName(d.name());
		l.setCode(d.code());
		return repo.save(l);
	}

	@Transactional
	public Language update(Long id, LanguageRequest d) {
		Language l = get(id);
		l.setName(d.name());
		l.setCode(d.code());
		return repo.save(l);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
