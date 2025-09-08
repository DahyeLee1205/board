package com.example.board.repository

import com.example.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {

    fun findTop4ByDelYnOrderByCreateDateDesc(delYn: Int) : MutableList<Board>
    fun findByDelYn(delYn : Int, pageable : Pageable) : Page<Board>
    fun findByIdAndDelYn(id : Int, delYn : Int) :Board
}
