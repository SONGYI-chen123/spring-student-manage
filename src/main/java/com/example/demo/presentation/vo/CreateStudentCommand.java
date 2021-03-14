package com.example.demo.presentation.vo;

import com.example.demo.common.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentCommand {
    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;
}
