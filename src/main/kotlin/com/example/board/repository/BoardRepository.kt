package com.example.board.repository

import com.example.board.dto.BoardDto
import com.example.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

import java.util.List;

interface BoardRepository : JpaRepository<Board, Long> {

    fun findTop4ByDelYnOrderByCreateDateDesc(delYn: Int) : List<Board>
    fun findByDelYn(delYn : Int, pageable : Pageable) : Page<Board>
    fun findByIdAndDelYn(id : Int, delYn : Int) :Board
}
