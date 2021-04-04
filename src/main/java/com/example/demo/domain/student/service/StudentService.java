package com.example.demo.domain.student.service;

import com.example.demo.application.dto.StudentDto;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public List<Student> getList() {
        return studentRepository.findAllStudents();
    }
}
