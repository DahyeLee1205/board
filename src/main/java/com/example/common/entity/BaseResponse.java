package com.example.common.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    private String code;
    private String status;
    private String message;
    private T data;
    private long timeStamp;

    // 성공 응답 생성
    // 성공 응답 생성
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>("10000", "SUCCESS", "요청이 성공적으로 처리되었습니다.", data);
    }

    // 실패 응답 생성
    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>("10999", "ERROR", message, null);
    }

    // 기본 생성자
    public BaseResponse() {
        this.timeStamp = System.currentTimeMillis(); // 기본 타임스탬프
    }

    // 모든 필드를 포함한 생성자
    public BaseResponse(String code, String status, String message, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }
}
