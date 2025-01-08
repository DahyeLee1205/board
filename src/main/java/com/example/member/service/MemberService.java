package com.example.member.service;

import com.example.member.dto.MemberDto;
import com.example.member.entity.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    
    // 회원가입
    ResponseEntity<String> joinMember(MemberDto memberDto);

    // 회원 조회
    ResponseEntity<List<Member>> findMember(MemberDto memberDto);

    // 회원정보 업데이트
    ResponseEntity <String> updateMember(MemberDto memberDto);
    
    // 회원 탈퇴
    ResponseEntity<String> deleteMember(MemberDto memberDto);

}
