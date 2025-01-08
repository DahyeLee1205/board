package com.example.member.entity;

import com.example.common.entity.BaseTime;
import com.example.common.entity.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;             // 회원 번호 (PK)

    @Column(name = "login_id")
    private String loginId;      // 로그인 ID

    @Column(name = "user_name")
    private String userName;         // 이름

    @Column(name = "password")
    private String password;     // 비밀번호

    @Column(name = "email")
    private String email;     // 비밀번호

    @Column(name = "gender")
    private int gender;       // 성별

    @Transient
    private Gender gen;      // 성별

    @Column(name = "birthday")
    private String birthday;  // 생년월일

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "user_status")
    private int userStatus;

    @Transient
    private Status status;// 삭제 여부



    @Builder
    public Member(String loginId, String password, String userName, String email, Gender gen, String birthday, String cellPhone, Status status) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.setGender(gen);
        this.birthday = birthday;
        this.cellPhone = cellPhone;
        this.setStatus(status);
    }

    // Getter와 Setter를 통해 변환 처리
    public Status getStatus() {
        return Status.fromValue(this.userStatus);
    }

    public void setStatus(Status status) {
        this.status = status;
        this.userStatus = status != null ? status.getValue() : 0; // null인 경우 기본값 설정
    }

    // Getter와 Setter를 통해 변환 처리
    public Gender getGender() {
        return Gender.fromValue(this.gender);
    }

    public void setGender(Gender gender) {
        this.gen = gender;
        this.gender = gen != null ? gen.getValue() : 0; // null인 경우 기본값 설정
    }
}
