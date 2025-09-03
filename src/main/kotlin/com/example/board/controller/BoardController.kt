package com.example.board.controller

import com.example.board.dto.BoardDto
import com.example.board.dto.BoardUpdateDto
import com.example.board.entity.Board
import com.example.board.service.BoardService
import com.example.common.entity.BaseResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import java.util.List

@Controller
@RequestMapping("/board")
class BoardController(private val boardService : BoardService) {
    @GetMapping("/")
    fun boardView() : String{
        return "main";
    }

    @GetMapping("/getLatestBoardList.do")
    @ResponseBody
    fun getLatestBoardList() : BaseResponse <List<Board>>  {
        return boardService.getLatestBoards();  // 최신 4개 게시글 반환
    }

    @GetMapping("/getBoardList.do")
    @ResponseBody
    fun getBoardList(
            @RequestParam(defaultValue = "0")  pageNo : Int,
            @RequestParam(defaultValue = "4")  pageSize : Int) : BaseResponse<Page<Board>> {
        return boardService.findAll(pageNo, pageSize);
    }

    @GetMapping("/getBoardDetail.do")
    @ResponseBody
    fun getBoardDetail(@RequestParam boardNo : Int) : BaseResponse<Board> {
        return boardService.getBoardDetail(boardNo);
    }

    @GetMapping("/crateBoard.do")
    fun createBoard(@RequestBody boardDto : BoardDto ) : ResponseEntity<String> {
        return boardService.saveBoard(boardDto);
    }

    @GetMapping("/updateBoard.do/{id}")
    fun updateBoard(@PathVariable  id : Long,
                    @RequestBody boardDto : BoardUpdateDto ) : ResponseEntity<String> {
        return boardService.updateBoard(boardDto,id);
    }

    @GetMapping("/deleteBoard.do/{id}")
    fun deleteBoard(@PathVariable id : Long ) : ResponseEntity<String> {
        return boardService.deleteBoard(id);
    }

}
