package com.poc.student_enroll.service;

import com.poc.student_enroll.mapper.EnrollmentMapper;
import com.poc.student_enroll.model.StudentRequest;
import com.poc.student_enroll.repository.EnrollmentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentConsumerService {

    private EnrollmentRepository enrollmentRepository;

    private EnrollmentMapper enrollmentMapper;

    public StudentConsumerService(EnrollmentRepository enrollmentRepository,
                                  EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    public void enrollStudent(final StudentRequest studentRequest) {
        enrollmentRepository.save(enrollmentMapper.toEnrollEntity(studentRequest));
    }
}
