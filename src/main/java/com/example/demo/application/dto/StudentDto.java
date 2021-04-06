package com.example.demo.application.dto;

import com.example.demo.common.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentDto {
    private String id;

    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;

    private List<CourseDto> courses;
}
