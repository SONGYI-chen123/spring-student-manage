package com.example.demo.domain.student.entity;

import lombok.Getter;

public enum Gender {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2);


    @Getter
    private Integer value;

    Gender(Integer value) {
        this.value = value;
    }
}
