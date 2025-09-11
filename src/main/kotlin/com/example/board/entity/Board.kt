package com.example.board.entity

import com.example.common.entity.BaseTime
import jakarta.persistence.*

@Entity
@Table(name = "board")
class Board protected constructor(
    @Column(name = "board_title")
    var boardTitle: String,

    @Column(name = "board_content")
    var boardContent: String,

    @Column(name = "user_no")
    var userNo: String,

    @Column(name = "del_yn")
    var delYn: Int = 0
) : BaseTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    var id: Long? = null
        protected set

    fun updateBoard(boardTitle: String, boardContent: String) {
        this.boardTitle = boardTitle
        this.boardContent = boardContent
    }

    companion object {
        fun create(boardTitle: String, boardContent: String, userNo: String): Board {
            return Board(boardTitle, boardContent, userNo, 0)
        }
    }
}
