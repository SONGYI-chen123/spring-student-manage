package com.example.demo.presentation.vo;

import com.example.demo.common.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private String id;

    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;
}
