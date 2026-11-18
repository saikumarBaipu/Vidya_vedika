package com.vidyavedika.payment_service.service;

import com.vidyavedika.payment_service.dto.*;
import com.vidyavedika.payment_service.entity.*;
import com.vidyavedika.payment_service.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaymentService {
	private final ContributionRepository repo;

	public PaymentService(ContributionRepository r) {
		repo = r;
	}

	public Contribution contribute(ContributionRequest r) {
		Contribution c = new Contribution();
		c.setUserId(r.userId());
		c.setAmount(r.amount());
		c.setReference(r.reference());
		return repo.save(c);
	}

	public List<Contribution> history(Long userId) {
		return repo.findByUserIdOrderByCreatedAtDesc(userId);
	}

	public double total() {
		return repo.findAll().stream().mapToDouble(Contribution::getAmount).sum();
	}
}
