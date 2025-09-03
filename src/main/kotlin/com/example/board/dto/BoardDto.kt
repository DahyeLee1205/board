package com.example.board.dto

import java.time.LocalDateTime

data class BoardDto (
    var id: Int = 0,
    var boardTitle : String? = null,   // 게시판 제목
    var boardContent :  String ?= null, // 게시판 내용
    var userNo : String ?= null,      // 사용자 번호
    var createDate : LocalDateTime ?= null,
    var delYn : Int = 0
)
