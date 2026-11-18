package com.vidyavedika.learning_service.repository;

import com.vidyavedika.learning_service.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.*;
import java.util.*;

public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
	List<DailyTask> findByTaskDateOrderByIdAsc(LocalDate date);
}
