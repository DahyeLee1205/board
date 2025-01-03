package com.example.board;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardApplicationTests {



    @Test
    void contextLoads() {
    }

    @Test
    public List<Board> getBoardList(){
        BoardRepository boardRepository = null;
        List<Board> list =  boardRepository.searchAllByDelYnIs();
        return list;
    }

}
