package com.workflow.engine.service;


import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.model.TaskInstance;
import com.workflow.engine.model.WorkflowInstance;
import com.workflow.engine.repository.TaskInstanceRepository;
import com.workflow.engine.repository.WorkflowInstanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkflowEngineService {

    @Autowired
    private WorkflowInstanceRepository workflowRepository;

    @Autowired
    private TaskInstanceRepository taskRepository;

    @Transactional
    public WorkflowInstance createWorkflow(WorkflowTemplateInputDTO workflowTemplateInputDTO) {
        WorkflowInstance workflow = new WorkflowInstance();
        workflow.setName(workflowTemplateInputDTO.getWorkflowName());
        workflow.setDescription(workflowTemplateInputDTO.getWorkflowDescription());
        workflow.setParameters(workflowTemplateInputDTO.getWorkflowParameters());
        workflow = workflowRepository.save(workflow);

        Map<String, TaskInstance> tasks = new HashMap<>();
        for(WorkflowTemplateInputDTO.TaskInputDTO taskInputDTO : workflowTemplateInputDTO.getTasks()){
            TaskInstance taskInstance = new TaskInstance();
            taskInstance.setStepName(taskInputDTO.getStepName());
            taskInstance.setCommand(taskInputDTO.getCommand());
            taskInstance.setParameters(taskInputDTO.getParameters());
            taskInstance.setWorkflow(workflow);
            tasks.put(taskInputDTO.getStepName(), taskRepository.save(taskInstance));
        }

        for(WorkflowTemplateInputDTO.TaskInputDTO taskInputDTO : workflowTemplateInputDTO.getTasks()){
            TaskInstance taskInstance = tasks.get(taskInputDTO.getStepName());
            List<TaskInstance> dependencies = new ArrayList<>();
            for(String dependency : taskInputDTO.getDependencies()){
                dependencies.add(tasks.get(dependency));
            }
            taskInstance.setDependencies(dependencies);
            taskRepository.save(taskInstance);
        }
        return workflow;
    }
}
