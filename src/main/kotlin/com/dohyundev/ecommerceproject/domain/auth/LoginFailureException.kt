package com.dohyundev.ecommerceproject.domain.auth

import com.dohyundev.ecommerceproject.common.exception.BusinessException

class LoginFailureException : BusinessException(DEFAULT_MESSAGE) {
    companion object {
        val DEFAULT_MESSAGE = "아이디 혹은 비밀번호를 확인해주세요."
    }
}