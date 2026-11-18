package com.vidyavedika.language_service.repository;

import com.vidyavedika.language_service.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public interface LanguageRepository extends JpaRepository<Language, Long> {
	Page<Language> findByNameContainingIgnoreCaseAndActiveTrue(String name, Pageable pageable);
}
