package com.example.board.dto

import java.time.LocalDateTime

data class BoardDto (
    var id: Int = 0,
    var boardTitle : String? = "",   // 게시판 제목
    var boardContent :  String ?= "", // 게시판 내용
    var userNo : String ?= "",      // 사용자 번호
    var createDate : LocalDateTime ?= LocalDateTime.now(),
    var delYn : Int = 0
)
