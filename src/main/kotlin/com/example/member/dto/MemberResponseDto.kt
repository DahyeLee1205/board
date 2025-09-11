package com.example.member.dto

data class MemberResponseDto(
    var totalCount: Int = 0
) {
    data class ListDto(
        var userStatus: Int = 0
    )
}
