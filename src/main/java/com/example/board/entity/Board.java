package com.example.board.entity;

import com.example.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;

@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long id;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "del_yn")
    private int delYn;

    @Builder
    public Board(String boardTitle, String boardContent, String userNo) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userNo = userNo;
        this.delYn = 0;
    }

    public void updateBoard(String boardTitle, String boardContent){
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}
