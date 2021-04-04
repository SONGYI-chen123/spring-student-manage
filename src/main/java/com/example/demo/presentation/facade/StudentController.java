package com.example.demo.presentation.facade;

import com.example.demo.application.service.StudentApplicationService;
import com.example.demo.presentation.vo.CreateStudentCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.presentation.assembler.StudentVoMapper.Mapper;

@RestController
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
}
