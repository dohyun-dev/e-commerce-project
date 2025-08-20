package com.dohyundev.ecommerceproject.auth.domain

import com.dohyundev.ecommerceproject.common.exception.AuthException

class InvalidTokenException(message: String = DEFAULT_MESSAGE) : AuthException(message) {
    companion object {
        val DEFAULT_MESSAGE = "유효하지 않은 토큰입니다.";
    }
}