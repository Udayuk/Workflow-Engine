package com.workflow.engine.repository;

import com.workflow.engine.model.TaskInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskInstanceRepository extends JpaRepository<TaskInstance, Long> {
}
