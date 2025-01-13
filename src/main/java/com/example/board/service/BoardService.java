package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.entity.Board;
import com.example.common.entity.BaseResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {

    BaseResponse<List<Board>> getLatestBoards();

    BaseResponse<Page<Board>> findAll(int pageNo, int pageSize);

    BaseResponse<Board> getBoardDetail(int boardNo);

    ResponseEntity<String> saveBoard(BoardDto boardDto);

    ResponseEntity<String> updateBoard(BoardUpdateDto boardDto, Long id);

    ResponseEntity<String> deleteBoard(Long id);
}
