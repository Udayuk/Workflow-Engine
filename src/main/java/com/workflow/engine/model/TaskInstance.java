package com.workflow.engine.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<TaskInstance> dependencies;

    private List<String> parameters;
}
