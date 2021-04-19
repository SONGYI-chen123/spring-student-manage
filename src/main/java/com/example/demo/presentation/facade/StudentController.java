package com.example.demo.presentation.facade;

import com.example.demo.application.service.StudentApplicationService;
import com.example.demo.presentation.vo.CreateStudentCommand;
import com.example.demo.presentation.vo.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.presentation.assembler.StudentVoMapper.Mapper;

@RestController
@Validated
@RequestMapping("/students")
public class StudentController {
    private final StudentApplicationService studentApplicationService;

    public StudentController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody CreateStudentCommand command) {
        studentApplicationService.addStudent(Mapper.toCreateStudentDto(command));
    }

    @GetMapping
    public List<StudentResponse> getList() {
        return studentApplicationService.getList().stream().map(Mapper::toStudentResponse).collect(Collectors.toList());
    }
}
