package com.example.board.dto;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
    private String boardTitle;   // 게시판 제목
    private String boardContent; // 게시판 내용
    private String userNo;       // 사용자 번호
}
