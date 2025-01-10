package com.example.board.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardUpdateDto;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.common.entity.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
    private final BoardRepository boardRepository;

    @Override
    public BaseResponse<List<Board>> getLatestBoards() {
        try{
            List<Board> boards = boardRepository.findTop4ByDelYnOrderByCreateDateDesc(0); // delYn이 0인 게시글 4개
            return BaseResponse.success(boards);
        } catch (Exception e){
            logger.error("e = " + e.getMessage());
            return BaseResponse.error("게시글 목록을 가져오는 데에 실패했습니다.");
        }
    }

    @Override
    public BaseResponse<Page<Board>> findAll(int pageNo, int pageSize){

        try{
            Pageable pagable = PageRequest.of(pageNo, pageSize);
            Page<Board> boardPage = boardRepository.findByDelYn(0, pagable);
            return BaseResponse.success(boardPage);
        }catch (Exception e){
            logger.error("e = " + e.getMessage());
            return BaseResponse.error("게시글 목록을 가져오는 데에 실패했습니다.");
        }
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
