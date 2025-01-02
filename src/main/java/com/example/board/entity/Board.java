package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private String createDate;
    private String userNo;
    private int delYn;

    @Builder
    public Board(String boardTitle, String boardContent, String userNo) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userNo = userNo;
    }

    public void updateBoard(String boardTitle, String boardContent){
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}
