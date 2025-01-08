package com.example.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
        private String loginId;
        private String password;
        private String userName;
        private String email;
        private int gender;
        private String birthday;
        private String cellPhone;
        private int status;
}
