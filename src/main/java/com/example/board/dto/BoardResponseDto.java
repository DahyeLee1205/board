package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardResponseDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListDto{
        int delYn;
    }
}
