package com.workflow.engine.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskInstance extends Auditable{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private WorkflowInstance workflow;

    private String stepName;

    private String command;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    private List<String> dependencies;
    private List<String> parameters;
}
