package com.example.sso.repository

import com.example.sso.entity.SsoLogin
import org.springframework.data.jpa.repository.JpaRepository

interface SsoLoginRepository : JpaRepository <SsoLogin, Long> {
}
