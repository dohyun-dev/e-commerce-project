package com.dohyundev.ecommerceproject.domain.member

import com.dohyundev.ecommerceproject.common.util.PasswordEncoder
import jakarta.persistence.Embeddable

@Embeddable
data class Password(val value: String) {
    companion object {
        fun create(rawPassword: String): Password {
            return Password(PasswordEncoder.encode(rawPassword))
        }
    }
}
