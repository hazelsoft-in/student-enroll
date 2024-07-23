package com.poc.student_enroll.repository;

import com.poc.student_enroll.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enroll, Long> {

    Enroll save(Enroll enrollment);
}
