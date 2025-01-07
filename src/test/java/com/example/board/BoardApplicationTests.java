package com.example.board;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void saveBoard() {
        Board saveParams = Board.builder()
                .boardTitle("테스트1")
                .boardContent("안녕하세요")
                .userNo("1")
                .build();

        Board board = boardRepository.save(saveParams);
        Assertions.assertEquals(board.getBoardTitle(), "테스트1");
    }

    @Test
    void findAllBoard(){
        boardRepository.findAll();
    }

    @Test
    void findBoardById(){
        Board board = boardRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
        Assertions.assertEquals(board.getBoardTitle(), "테스트1");
    }

}
