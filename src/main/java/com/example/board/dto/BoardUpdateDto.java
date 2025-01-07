package com.example.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateDto {
    private String boardTitle;   // 게시판 제목
    private String boardContent; // 게시판 내용
}
