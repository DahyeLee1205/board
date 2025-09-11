package com.example.member.entity

import com.example.common.entity.BaseTime
import com.example.common.entity.Status
import com.example.member.dto.MemberDto
import jakarta.persistence.*

@Entity
@Table(name = "member")
class Member protected constructor(

    @Column(name = "login_id")
    var loginId: String,     // 로그인 ID

    @Column(name = "user_name")
    var userName: String,    // 이름

    @Column(name = "password")
    var password: String,    // 비밀번호

    @Column(name = "email")
    var email: String,       // 이메일

    @Column(name = "gender")
    var gender: Int,         // 성별

    @Transient
    var gen: Gender,         // 성별(Enum)

    @Column(name = "birthday")
    var birthday: String,    // 생년월일

    @Column(name = "cell_phone")
    var cellPhone: String,

    @Column(name = "user_status")
    var userStatus: Int      // DB 컬럼 (0/1)

) : BaseTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    var userNo: Long? = null
        protected set

    // status는 userStatus 기반으로 계산, @Transient
    @get:Transient
    val status: Status
        get() = Status.fromValue(userStatus)

    fun updateMember(memberDto: MemberDto) {
        memberDto.loginId = this.loginId
        memberDto.password = this.password
        memberDto.userName = this.userName
        memberDto.email = this.email
        memberDto.birthday = this.birthday
        memberDto.cellPhone = this.cellPhone

        this.userStatus = memberDto.status // status 계산 속성으로 자동 반영됨
    }

    companion object {
        fun create(
            loginId: String,
            password: String,
            userName: String,
            email: String,
            gen: Gender,
            birthday: String,
            cellPhone: String,
            status: Status
        ): Member {
            return Member(
                loginId = loginId,
                password = password,
                userName = userName,
                email = email,
                gender = gen.value,
                gen = gen,
                birthday = birthday,
                cellPhone = cellPhone,
                userStatus = status.value
            )
        }
    }
}