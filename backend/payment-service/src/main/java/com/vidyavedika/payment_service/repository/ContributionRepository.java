package com.vidyavedika.payment_service.repository;

import com.vidyavedika.payment_service.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
	List<Contribution> findByUserIdOrderByCreatedAtDesc(Long userId);
}
