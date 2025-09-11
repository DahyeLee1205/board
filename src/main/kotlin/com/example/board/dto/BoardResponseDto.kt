package com.example.board.dto

data class BoardResponseDto(
    var totalCount: Int = 0
) {
    data class ListDto(
        var delYn: Int = 0
    )
}
