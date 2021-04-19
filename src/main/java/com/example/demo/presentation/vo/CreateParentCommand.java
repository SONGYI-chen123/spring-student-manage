package com.example.demo.presentation.vo;

import com.example.demo.common.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateParentCommand {
    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;

    private String workAddress;
}
