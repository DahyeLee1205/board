package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {
    List<BoardResponseDto.ListDto> findAll();

    ResponseEntity<String> saveBoard(BoardDto boardDto);

    ResponseEntity<String> updateBoard(BoardUpdateDto boardDto, Long id);

    ResponseEntity<String> deleteBoard(Long id);
}
