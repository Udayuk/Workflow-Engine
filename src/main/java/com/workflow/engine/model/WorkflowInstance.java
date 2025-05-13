package com.workflow.engine.model;

import com.workflow.engine.model.template.WorkflowTemplate;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowInstance extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    private List<String> parameters;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<TaskInstance> tasks;

    @ManyToOne
    private WorkflowTemplate workflowTemplate;
}
