package com.example.demo.presentation.vo;

import com.example.demo.common.entity.Gender;
import com.sun.istack.NotNull;
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
    @NotNull
    private String name;

    @NotNull
    private Gender gender;

    @NotNull
    private Integer age;

    @NotNull
    private String phoneNumber;

    private CreateParentCommand parent;
}
