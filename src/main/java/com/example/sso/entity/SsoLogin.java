package com.example.sso.entity;

import com.example.common.entity.BaseTime;
import com.example.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "sso_login")
public class SsoLogin extends BaseTime {

    @Id
    @Column(name = "sso_login_id")
    int ssoLoginId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_no", referencedColumnName = "user_no")
    Member member;

    @Column(name = "social_code")
    int socialCode;

    @Column(name = "external_id")
    String externalId;

    @Column (name = "access_token")
    String accessToken;

}
