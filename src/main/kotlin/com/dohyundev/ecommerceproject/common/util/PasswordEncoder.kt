package com.dohyundev.ecommerceproject.common.util

import java.security.MessageDigest
import java.util.Base64

class PasswordEncoder {
    companion object {
        fun encode(input: String): String {
            val digest = MessageDigest.getInstance("SHA-256")
            val hash = digest.digest(input.toByteArray(Charsets.UTF_8))
            return Base64.getEncoder().encodeToString(hash)
        }
    }
}