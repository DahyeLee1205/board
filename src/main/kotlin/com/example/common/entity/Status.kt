package com.example.common.entity

enum class Status(val value: Int) {
    ACTIVE(1),
    INACTIVE(0);

    companion object{
        fun fromValue (value :Int) :Status {
            return values().find {it.value == value }
                    ?:throw IllegalArgumentException("Invaild tinyInt value: $value")
        }
    }
}