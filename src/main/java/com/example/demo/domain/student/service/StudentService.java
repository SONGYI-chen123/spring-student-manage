package com.example.demo.domain.student.service;

import com.example.demo.domain.student.entity.Parent;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.ParentRepository;
import com.example.demo.domain.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;

    public StudentService(StudentRepository studentRepository, ParentRepository parentRepository) {
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
    }

    public void addStudent(Student student) {
        Student addStudent = studentRepository.add(student);
        Parent parent = student.getParent();
        parent.setStudentId(addStudent.getId());
        parentRepository.add(parent);
    }

    public List<Student> getList() {
        return new ArrayList<>(studentRepository.findAllStudents().values());
    }
}
