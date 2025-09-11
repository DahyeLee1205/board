package com.example.member.dto

import lombok.NoArgsConstructor

@NoArgsConstructor
class MemberDto(
    var loginId: String,
    var password: String,
    var userName: String,
    var email: String,
    var gender: Int,
    var birthday: String,
    var cellPhone: String,
    var status: Int
)
