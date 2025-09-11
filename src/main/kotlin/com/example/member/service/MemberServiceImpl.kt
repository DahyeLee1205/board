package com.example.member.service

import com.example.common.entity.Status
import com.example.member.dto.MemberDto

import com.example.member.entity.Gender
import com.example.member.entity.Member
import com.example.member.repository.MemberRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {

    override fun joinMember(memberDto: MemberDto): ResponseEntity<String> {
        // 엔티티 조회 (중복 아이디 조회)
        val findMember = memberRepository.findByLoginId(
            loginId = memberDto.loginId
        )

        if (!findMember.isEmpty()) {
            System.out.println("already enrolled member = " + memberDto.loginId)
            return ResponseEntity.internalServerError().build() // 404 처리
        }

        val saveParams = Member.create(
            loginId = memberDto.loginId,
            password = memberDto.password,
            userName = memberDto.userName,
            email = memberDto.email,
            gen = Gender.fromValue(memberDto.gender),
            birthday = memberDto.birthday,
            cellPhone = memberDto.cellPhone,
            status = Status.fromValue(memberDto.status)
        )
        val member = memberRepository.save(saveParams)
        return ResponseEntity.ok("Member saved successfilly! \nloginId : " + member.loginId);
    }

    override fun findMember(memberDto: MemberDto): ResponseEntity<MutableList<Member>> {
        // 회원 조회
        val findMember = memberRepository.findByLoginId(
            loginId = memberDto.loginId
        )
        return if (findMember.isEmpty())
            ResponseEntity.ok(null) // Null
        else
            return ResponseEntity.ok(findMember)
    }

    override fun updateMember(memberDto: MemberDto): ResponseEntity<String> {
        // 회원 정보 업데이트
        val findMember = memberRepository.findByLoginId(
            loginId = memberDto.loginId
        )
        if (findMember.isEmpty()) {
            return ResponseEntity.ok(null) // Null
        }
        val member = findMember[0]
        member.updateMember(memberDto)

        return ResponseEntity.ok("Member saved successfilly! \nloginId : " + member.loginId)
    }

    override fun deleteMember(memberDto: MemberDto): ResponseEntity<String> {
        // 회원 탈퇴
        val findMember = memberRepository.findByLoginId(
            loginId = memberDto.loginId
        )
        if (findMember.isEmpty()) {
            return ResponseEntity.ok(null) // Null
        }

        val member = findMember[0]
        member.updateMember(memberDto)

        return ResponseEntity.ok("Member deleted successfilly! \nloginId : " + member.loginId)
    }

    override fun doLogin(memberDto: MemberDto): ResponseEntity<String> {
        val members = memberRepository.findByLoginId(
            loginId = memberDto.loginId
        )

        members[0]?.let { member ->
            val passWd = memberDto.password
            val memberPassWd = member.password

            val passwordEncoder = BCryptPasswordEncoder()

            val isLogin: Boolean = passwordEncoder.matches(
                passWd, memberPassWd
            )
            if (isLogin) {
                // 로그인 세션 추가
            }
        }
        return ResponseEntity.ofNullable("")
    }
}
