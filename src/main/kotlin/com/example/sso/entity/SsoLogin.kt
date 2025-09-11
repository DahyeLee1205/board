package com.example.sso.entity

import com.example.common.entity.BaseTime
import com.example.member.entity.Member
import jakarta.persistence.*

@Entity
@Table(name = "sso_login")
class SsoLogin protected constructor(

    @Id
    @Column(name = "sso_login_id")
    var ssoLoginId: Int,

    @ManyToOne(cascade = arrayOf(CascadeType.REMOVE))
    @JoinColumn(name = "user_no", referencedColumnName = "user_no")
    var member: Member,

    @Column(name = "social_code")
    var socialCode: Int,

    @Column(name = "external_id")
    var externalId: String,

    @Column(name = "access_token")
    var accessToken: String

) : BaseTime() {

}
