package com.workflow.engine.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "tasks-execution";

    public TaskProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTask(String task) {
        kafkaTemplate.send(topic, task);
    }
}
