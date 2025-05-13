package com.workflow.engine.service;

import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.kafka.TaskProducer;
import com.workflow.engine.model.WorkflowInstance;
import com.workflow.engine.repository.TaskInstanceRepository;
import com.workflow.engine.repository.WorkflowInstanceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkflowExecutionService {
    private final WorkflowInstanceRepository workflowInstanceRepository;
    private final TaskInstanceRepository taskInstanceRepository;
    private final TaskProducer taskProducer;
    public WorkflowExecutionService(WorkflowInstanceRepository workflowInstanceRepository, TaskInstanceRepository taskInstanceRepository, TaskProducer taskProducer) {
        this.workflowInstanceRepository = workflowInstanceRepository;
        this.taskInstanceRepository = taskInstanceRepository;
        this.taskProducer = taskProducer;
    }

//    public void executeWorkflow(WorkflowTemplateInputDTO workflowTemplateInputDTO) {
//        WorkflowInstance workflowInstance =
//    }
}
