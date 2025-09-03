package com.example.board.dto

data class BoardUpdateDto (
    var boardTitle : String ?= null,   // 게시판 제목
    var boardContent : String ?= null// 게시판 내용
)
