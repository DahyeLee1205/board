package com.example.member.entity

enum class Gender(val value: Int) {
    M(1),
    F(0);

    companion object {
        fun fromValue(value: Int): Gender {
            return Gender.entries.find { it.value == value }
                ?: throw IllegalArgumentException("Invaild tinyInt value: $value")
        }
    }
}
