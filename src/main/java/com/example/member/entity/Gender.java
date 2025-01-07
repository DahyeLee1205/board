package com.example.member.entity;

import com.example.common.entity.Status;

public enum  Gender {
    M(1), F(0);

    private final int value;
    Gender(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // tinyInt 값으로부터 Enum을 찾는 정적 메서드
    public static Gender fromValue(int value) {
        for (Gender gender : Gender.values()) {
            if (gender.value == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid tinyInt value: " + value);
    }
}
