package com.example.demo.application.dto;
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
public class ParentDto {
    private String name;

    private Gender gender;

    private Integer age;

    private String phoneNumber;

    private String workAddress;
}
