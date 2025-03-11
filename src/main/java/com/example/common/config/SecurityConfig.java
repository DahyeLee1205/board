package com.example.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/*        http.csrf().disable().authorizeHttpRequests()  // deprecated 된 authorizeRequests() 대신 사용
                .requestMatchers("/login", "/register").permitAll()  // 로그인, 회원가입은 누구나 접근 가능
                .anyRequest().authenticated()  // 나머지 요청은 인증 필요
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)  // 로그인 성공 후 이동 URL
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true");  // 로그아웃 성공 후 이동 URL

        return http.build();*/

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
