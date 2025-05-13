package com.workflow.engine.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.model.template.TaskDependency;
import com.workflow.engine.model.template.TaskTemplate;
import com.workflow.engine.model.template.WorkflowTemplate;
import com.workflow.engine.repository.TaskDependencyRepository;
import com.workflow.engine.repository.TaskTemplateRepository;
import com.workflow.engine.repository.WorkflowTemplateRepository;
import com.workflow.engine.service.WorkflowTemplateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;
    private final TaskTemplateRepository taskTemplateRepository;
    private final TaskDependencyRepository taskDependencyRepository;

    @Transactional
    public WorkflowTemplate createWorkflowTemplate(WorkflowTemplateInputDTO workflowTemplateInputDTO) throws JsonProcessingException {
        WorkflowTemplate workflowTemplate = new WorkflowTemplate();
        workflowTemplate.setName(workflowTemplateInputDTO.getWorkflowName());
        workflowTemplate.setDescription(workflowTemplateInputDTO.getWorkflowDescription());

        ObjectMapper objectMapper = new ObjectMapper();
        String workflowParamsJson = objectMapper.writeValueAsString(workflowTemplateInputDTO.getWorkflowParameters());
        workflowTemplate.setParameters(workflowParamsJson);

        WorkflowTemplate savedWorkflowTemplate = workflowTemplateRepository.save(workflowTemplate);

        Map<String, TaskTemplate> tasksMap = new HashMap<>();

        for(WorkflowTemplateInputDTO.TaskDTO taskTemplateDTO : workflowTemplateInputDTO.getTasks()) {
            TaskTemplate taskTemplate = new TaskTemplate();
            taskTemplate.setName(taskTemplateDTO.getTaskName());
            taskTemplate.setType(taskTemplateDTO.getTaskType());

            String taskParamsJson = objectMapper.writeValueAsString(taskTemplateDTO.getTaskParameters());
            taskTemplate.setParameters(taskParamsJson);
            taskTemplate.setWorkflowTemplate(savedWorkflowTemplate);

            taskTemplate = taskTemplateRepository.save(taskTemplate);
            tasksMap.put(taskTemplateDTO.getTaskName(), taskTemplate);
        }

        for(WorkflowTemplateInputDTO.DependencyDTO dependencyDTO : workflowTemplateInputDTO.getDependencies()) {
            TaskDependency taskDependency = new TaskDependency();
            taskDependency.setWorkflowTemplate(savedWorkflowTemplate);
            taskDependency.setFromTaskName(dependencyDTO.getFrom()); //doubt
            taskDependency.setToTaskName(dependencyDTO.getTo());
            taskDependencyRepository.save(taskDependency);
        }
        return savedWorkflowTemplate;
    }
}
