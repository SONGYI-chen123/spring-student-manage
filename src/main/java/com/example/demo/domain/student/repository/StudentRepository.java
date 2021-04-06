package com.example.demo.domain.student.repository;

import com.example.demo.domain.student.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepository {
    Student saveStudent(Student student);

    Map<String,Student> findAllStudents();
}
