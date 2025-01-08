package com.example.sso.repository;

import com.example.sso.entity.SsoLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoLoginRepository extends JpaRepository <SsoLogin, Long> {
}
