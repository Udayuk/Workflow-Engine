package com.workflow.engine.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WorkflowInputDTO {
    private String workflowName;
    private String workflowDescription;
    private Map<String, Object> workflowParameters;
    private List<TaskInputDTO> tasks;

    @Data
    public static class TaskInputDTO{
        private String stepName;
        private String command;
        private List<String> dependencies;
        private Map<String, Object> parameters;
    }
}
