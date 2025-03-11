package com.example.member.service;

import com.example.common.entity.Status;
import com.example.member.dto.MemberDto;
import com.example.member.entity.Gender;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public ResponseEntity<String> joinMember(MemberDto memberDto) {
        // 엔티티 조회 (중복 아이디 조회)
        List<Member> findMember = memberRepository.findByLoginId(memberDto.getLoginId());

        if (!findMember.isEmpty()) {
            System.out.println("already enrolled member = " + memberDto.getLoginId());
            return ResponseEntity.internalServerError().build(); // 404 처리
        }

        Member saveParams = Member.builder()
                .loginId(memberDto.getLoginId())
                .password(memberDto.getPassword())
                .userName(memberDto.getUserName())
                .email(memberDto.getEmail())
                .gen(Gender.fromValue(memberDto.getGender()))
                .birthday(memberDto.getBirthday())
                .cellPhone(memberDto.getCellPhone())
                .status(Status.fromValue(memberDto.getStatus()))
                .build();
        Member member = memberRepository.save(saveParams);
        return ResponseEntity.ok("Member saved successfilly! \nloginId : " + member.getLoginId());
    }

    @Override
    public ResponseEntity<List<Member>> findMember(MemberDto memberDto) {

        // 회원 조회
        List<Member> findMember = memberRepository.findByLoginId(memberDto.getLoginId());

        if (findMember.isEmpty()) {
            return ResponseEntity.ok(null); // Null
        }
        return ResponseEntity.ok(findMember);
    }

    @Override
    public ResponseEntity<String> updateMember(MemberDto memberDto) {
        // 회원 정보 업데이트
        List<Member> findMember = memberRepository.findByLoginId(memberDto.getLoginId());
        if (findMember.isEmpty()) {
            return ResponseEntity.ok(null); // Null
        }

        Member member = findMember.get(0);
        member.updateMember(memberDto);

        return ResponseEntity.ok("Member saved successfilly! \nloginId : " + member.getLoginId());
    }

    @Override
    public ResponseEntity<String> deleteMember(MemberDto memberDto) {
        // 회원 탈퇴
        List<Member> findMember = memberRepository.findByLoginId(memberDto.getLoginId());
        if (findMember.isEmpty()) {
            return ResponseEntity.ok(null); // Null
        }

        Member member = findMember.get(0);
        member.updateMember(memberDto);

        return ResponseEntity.ok("Member deleted successfilly! \nloginId : " + member.getLoginId());
    }

    @Override
    public ResponseEntity<String> doLogin(MemberDto memberDto) {
        List<Member> members = memberRepository.findByLoginId(memberDto.getLoginId());

        if (members.get(0) != null && members.size() > 0) {
            Member member = members.get(0);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            boolean isLogin = passwordEncoder.matches(memberDto.getPassword(), member.getPassword());
            if(isLogin){
                // 로그인 세션 추가

            }
        }
        return null;
    }
}
