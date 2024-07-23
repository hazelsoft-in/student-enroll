package com.poc.student_enroll.mapper;

import com.poc.student_enroll.entity.Enroll;
import com.poc.student_enroll.model.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source="id", target="studentId")
    Enroll toEnrollEntity(StudentRequest student);
    //Student toStudentEntity(StudentRequest studentRequest);
}
