package com.example.member.controller

import com.example.member.dto.MemberDto
import com.example.member.entity.Member
import com.example.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/member")
class MemberController(private val memberService: MemberService) {

    @GetMapping("/memberJoinPage.do")
    fun memberJoinView() = ""

    @GetMapping("/joinMember.do")
    fun joinMember(@RequestBody memberDto: MemberDto): ResponseEntity<String> {
        return memberService.joinMember(memberDto)
    }

    @GetMapping("/findMember.do")
    fun findMember(@RequestBody memberDto: MemberDto): ResponseEntity<MutableList<Member>> {
        return memberService.findMember(memberDto)
    }

    @GetMapping("/updateMember.do")
    fun updateMember(@RequestBody memberDto: MemberDto): ResponseEntity<String> {
        return memberService.updateMember(memberDto)
    }

    @GetMapping("/deleteMember.do")
    fun deleteMember(@RequestBody memberDto: MemberDto): ResponseEntity<String> {
        return memberService.deleteMember(memberDto)
    }

    @PostMapping("doLogin.do")
    fun doLogin(@RequestBody memberDto: MemberDto): ResponseEntity<String> {
        return memberService.doLogin(memberDto)
    }

}
