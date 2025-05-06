package com.workflow.engine.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime;

@Data
@Entity
public class TaskExecutionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TaskInstance task;

    private String logOutput;

    private LocalDateTime timestamp;
}
