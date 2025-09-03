package com.example.member.repository

import com.example.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

import java.util.List

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByLoginId(loginId : String) : List<Member>
}
