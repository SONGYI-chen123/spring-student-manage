package com.example.demo.domain.student.repository;

import com.example.demo.domain.student.entity.Student;

import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student);

    List<Student> findAllStudents();
}
