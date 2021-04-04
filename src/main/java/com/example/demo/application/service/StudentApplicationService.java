package com.example.demo.application.service;

import com.example.demo.application.dto.StudentDto;
import com.example.demo.domain.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.application.assembler.StudentDtoMapper.Mapper;

@Service
public class StudentApplicationService {
    private final StudentService studentService;

    public StudentApplicationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(StudentDto dto) {
        studentService.addStudent(Mapper.toStudent(dto));
    }

    public List<StudentDto> getList() {
        return studentService.getList().stream().map(Mapper::toDto).collect(Collectors.toList());
    }
}
