package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    @Autowired
    BoardRepository boardRepositorY;
    public List<Board> getBoardList(){
        List<Board> list =  boardRepositorY.searchAllByDelYnIs();
        return list;
    }
}
