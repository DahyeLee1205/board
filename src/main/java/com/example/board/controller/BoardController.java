package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    private String boardView(){
        return "main";
    }

    @GetMapping("/getBoardList.do")
    private List<BoardResponseDto.ListDto> getBoardList(){
        return boardService.findAll();
    }

    @GetMapping("/crateBoard.do")
    private ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto){
        return boardService.saveBoard(boardDto);
    }

    @GetMapping("/updateBoard.do/{id}")
    private ResponseEntity<String> updateBoard(@PathVariable Long id,
                                               @RequestBody BoardUpdateDto boardDto){
        return boardService.updateBoard(boardDto,id);
    }

    @GetMapping("/deleteBoard.do/{id}")
    private ResponseEntity<String> deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }

}
