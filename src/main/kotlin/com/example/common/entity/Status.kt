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
/*    private final int value;
    Status(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // tinyInt 값으로부터 Enum을 찾는 정적 메서드
    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid tinyInt value: " + value);
    }
}*/
