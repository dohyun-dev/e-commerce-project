package com.dohyundev.ecommerceproject.member.domain

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class MemberNotFoundException(
    override val message: String = DEFAULT_MESSAGE,
) : NotFoundException(message) {
    companion object {
        private const val DEFAULT_MESSAGE = "존재하지 않는 회원입니다.";
    }
}