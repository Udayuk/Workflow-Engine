package com.workflow.engine.controller;

import com.workflow.engine.dto.WorkflowTemplateInputDTO;
import com.workflow.engine.service.WorkflowEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowEngineService workflowEngineService;

    @PostMapping("/start")
    public ResponseEntity<String> createdWorkflow(@RequestBody WorkflowTemplateInputDTO workflowTemplateInputDTO) {
        workflowEngineService.createWorkflow(workflowTemplateInputDTO);
        return ResponseEntity.ok("Workflow created Successfully");
    }

    @PostMapping("/{workflowId}/execute")
    public ResponseEntity<String> executedWorkflow(@PathVariable Long workflowId) {

    }

}
