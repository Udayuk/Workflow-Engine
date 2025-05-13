package com.workflow.engine.service.impl;

import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.model.template.WorkflowTemplate;
import com.workflow.engine.repository.TaskDependencyRepository;
import com.workflow.engine.repository.TaskTemplateRepository;
import com.workflow.engine.repository.WorkflowTemplateRepository;
import com.workflow.engine.service.WorkflowTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;
    private final TaskTemplateRepository taskTemplateRepository;
    private final TaskDependencyRepository taskDependencyRepository;

    @Transient
    public WorkflowTemplate createWorkflowTemplate(WorkflowTemplateInputDTO workflowTemplateInputDTO) {
        return null;
    }
}
