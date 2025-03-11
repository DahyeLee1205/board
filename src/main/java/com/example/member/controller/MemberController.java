package com.example.member.controller;

import com.example.member.dto.MemberDto;
import com.example.member.entity.Member;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/memberJoinPage.do")
    private String memberJoinView(){return ""; }

    @GetMapping("/joinMember.do")
    private ResponseEntity<String> joinMember(@RequestBody MemberDto memberDto){
        return memberService.joinMember(memberDto);
    }

    @GetMapping("/findMember.do")
    private ResponseEntity<List<Member>> findMember(@RequestBody MemberDto memberDto){
        return memberService.findMember(memberDto);
    }

    @GetMapping("/updateMember.do")
    private ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto){
        return memberService.updateMember(memberDto);
    }

    @GetMapping("/deleteMember.do")
    private ResponseEntity<String> deleteMember(@RequestBody MemberDto memberDto){
        return memberService.deleteMember(memberDto);
    }

    @PostMapping("/doLogin.do")
    private ResponseEntity<String> doLogin(@RequestBody MemberDto memberDto){
        return memberService.doLogin(memberDto);
    }

}
