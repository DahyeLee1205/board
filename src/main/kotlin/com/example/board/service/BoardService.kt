package com.example.board.service

import com.example.board.dto.BoardDto
import com.example.board.dto.BoardResponseDto
import com.example.board.dto.BoardUpdateDto
import com.example.board.entity.Board
import com.example.common.entity.BaseResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity

import java.util.List;

interface BoardService {

    fun getLatestBoards() : BaseResponse<List<Board>>

    fun findAll(pageNo : Int, pageSize : Int) : BaseResponse<Page<Board>>

    fun getBoardDetail(boardNo : Int) : BaseResponse<Board>

    fun saveBoard(boardDto : BoardDto) : ResponseEntity<String>

    fun updateBoard(boardDto : BoardUpdateDto, id : Long) : ResponseEntity<String>

    fun deleteBoard(id : Long) : ResponseEntity<String> ;
}
