package com.dohyundev.ecommerceproject.member.api.dto

import com.dohyundev.ecommerceproject.member.domain.Password
import jakarta.validation.constraints.NotBlank

interface MemberRequest {
    class Create(
        @NotBlank(message = "아이디는 필수입니다.")
        val username: String,
        @NotBlank(message = "비밀번호는 필수입니다.")
        val password: String,
    ) {
        fun toPassword() : Password {
            return Password.create(password)
        }
    }
}