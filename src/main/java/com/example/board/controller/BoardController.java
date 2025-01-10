package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import com.example.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getLatestBoardList.do")
    @ResponseBody
    public BaseResponse<List<Board>> getLatestBoardList() {
        return boardService.getLatestBoards();  // 최신 4개 게시글 반환
    }

    @GetMapping("/getBoardList.do")
    @ResponseBody
    private BaseResponse<Page<Board>> getBoardList(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "4") int pageSize
    ){
        return boardService.findAll(pageNo, pageSize);
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
