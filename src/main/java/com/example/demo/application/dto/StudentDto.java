package com.example.demo.application.dto;

import com.example.demo.common.entity.Gender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;
}
