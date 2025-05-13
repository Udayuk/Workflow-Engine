package com.workflow.engine.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Data
public class WorkflowTemplateInputDTO {
    private String workflowName;
    private String workflowDescription;
    private Map<String, Object> workflowParameters;
    private List<TaskDTO> tasks;
    private List<DependencyDTO> dependencies;

    @Data
    public static class TaskDTO{
        private String taskName;
        private String taskType;
        private Map<String, Object> taskParameters;
    }

    @Data
    public static class DependencyDTO{
        private String from;
        private String to;
    }
}
