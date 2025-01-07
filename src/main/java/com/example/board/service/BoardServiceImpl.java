package com.example.board.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public List<BoardResponseDto.ListDto> findAll(){
        return boardRepository.findAll().stream().map(a -> new
                BoardResponseDto.ListDto()).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> saveBoard(BoardDto boardDto) {
        Board saveParams = Board.builder()
                .boardTitle(boardDto.getBoardTitle())
                .boardContent(boardDto.getBoardContent())
                .userNo(boardDto.getUserNo())
                .build();

        Board board = boardRepository.save(saveParams);
        return ResponseEntity.ok("Board saved successfully!");
    }

    @Override
    public ResponseEntity<String> updateBoard(BoardUpdateDto boardDto, Long id) {

        // 엔티티 조회
        Optional<Board> findBoard = boardRepository.findById(id);

        if (findBoard.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 처리
        }

        Board board = findBoard.get();
        board.updateBoard(boardDto.getBoardTitle(), boardDto.getBoardContent());
        boardRepository.save(board);

        return ResponseEntity.ok("Board updated successfully!");
    }

    @Override
    public ResponseEntity<String> deleteBoard(Long id) {
        // 엔티티 조회
        Optional<Board> findBoard = boardRepository.findById(id);

        if (findBoard.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 처리
        }
        Board board = findBoard.get();
        boardRepository.delete(board);
        return ResponseEntity.ok("Board deleted successfully!");
    }
}
