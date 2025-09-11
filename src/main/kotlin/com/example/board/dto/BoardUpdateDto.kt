package com.example.board.dto

data class BoardUpdateDto(
    var boardTitle: String? = "",   // 게시판 제목
    var boardContent: String? = ""// 게시판 내용
)
