package com.workflow.engine.model.template;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "workflow_templates")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(columnDefinition = "jsonb")
    private String parameters;

    @OneToMany(mappedBy = "workflowTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskTemplate> tasks;

    @OneToMany(mappedBy = "workflowTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskDependency> dependencies;
}
