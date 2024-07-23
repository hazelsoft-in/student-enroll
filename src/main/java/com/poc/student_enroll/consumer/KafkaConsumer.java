package com.poc.student_enroll.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.student_enroll.mapper.EnrollmentMapper;
import com.poc.student_enroll.model.StudentRequest;
import com.poc.student_enroll.service.StudentConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private StudentConsumerService studentConsumerService;

    public KafkaConsumer(StudentConsumerService studentConsumerService) {
        this.studentConsumerService = studentConsumerService;
    }

    @KafkaListener(topics = "student", groupId = "enroll")
    public void consumerMessage(String message) {
        StudentRequest student = null;
        try {
            student = OBJECT_MAPPER.readValue(message, StudentRequest.class);
        } catch (JsonProcessingException jme) {
            //log error
        }
        studentConsumerService.enrollStudent(student);
    }
}
