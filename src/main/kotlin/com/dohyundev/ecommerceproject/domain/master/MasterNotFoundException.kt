package com.dohyundev.ecommerceproject.domain.master

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class MasterNotFoundException(
    override val message: String?,
) : NotFoundException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "마스터 정보가 존재하지 않습니다.";
    }
}