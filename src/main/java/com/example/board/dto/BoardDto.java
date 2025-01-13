package com.example.board.dto;
import lombok.NoArgsConstructor;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
    private int id;
    private String boardTitle;   // 게시판 제목
    private String boardContent; // 게시판 내용
    private String userNo;       // 사용자 번호
    private LocalDateTime createDate;
    private int delYn;
}
