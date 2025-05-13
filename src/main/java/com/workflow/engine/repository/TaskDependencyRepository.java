package com.workflow.engine.repository;

import com.workflow.engine.model.template.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDependencyRepository extends JpaRepository<TaskDependency, Long> {
}
