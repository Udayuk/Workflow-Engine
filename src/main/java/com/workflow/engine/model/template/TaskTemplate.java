package com.workflow.engine.model.template;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "task_templates")
@Entity
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class TaskTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Column(columnDefinition = "jsonb")
    private String parameters; //JSON

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_template_id")
    private WorkflowTemplate workflowTemplate;
}
