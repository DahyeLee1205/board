package com.example.board.repository;

import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findTop4ByDelYnOrderByCreateDateDesc(int delYn);
    Page<Board> findByDelYn(int delYn, Pageable pageable);
    Board findByIdAndDelYn(int id, int delYn);
}
