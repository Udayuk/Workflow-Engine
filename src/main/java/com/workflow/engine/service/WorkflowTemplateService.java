package com.workflow.engine.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.model.template.WorkflowTemplate;

public interface WorkflowTemplateService {
    WorkflowTemplate createWorkflowTemplate(WorkflowTemplateInputDTO workflowTemplateInputDTO) throws JsonProcessingException;
}
