package com.dohyundev.ecommerceproject.domain.master

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class DuplicatedUsernameException(
    override val message: String = DEFAULT_MESSAGE,
) : NotFoundException(message) {

    companion object {
        private const val DEFAULT_MESSAGE = "이미 사용 중인 아이디입니다.";
    }
}