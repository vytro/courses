package com.diplomado.courses.services;

import com.diplomado.courses.domain.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {

//    List<Enrollment> getEnrollmentByStudentId(Integer studentId);
    Enrollment save(Enrollment enrollment);


    List<Enrollment> getEnrollmentsByStudentId(Integer studentId);
}
