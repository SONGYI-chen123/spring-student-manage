package com.example.demo.domain.student.entity;
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
public class Parent {
    private String id;

    private String studentId;

    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;

    private String workAddress;
}
