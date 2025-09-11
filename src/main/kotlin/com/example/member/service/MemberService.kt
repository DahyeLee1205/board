package com.example.member.service

import com.example.member.dto.MemberDto
import com.example.member.entity.Member
import org.springframework.http.ResponseEntity

interface MemberService {

    // 회원가입
    fun joinMember(memberDto: MemberDto): ResponseEntity<String>

    // 회원 조회
    fun findMember(memberDto: MemberDto): ResponseEntity<MutableList<Member>>

    // 회원정보 업데이트
    fun updateMember(memberDto: MemberDto): ResponseEntity<String>

    // 회원 탈퇴
    fun deleteMember(memberDto: MemberDto): ResponseEntity<String>

    fun doLogin(memberDto: MemberDto): ResponseEntity<String>

}
