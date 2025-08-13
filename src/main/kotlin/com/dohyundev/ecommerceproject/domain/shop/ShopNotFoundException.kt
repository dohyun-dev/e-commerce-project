package com.dohyundev.ecommerceproject.domain.shop

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class ShopNotFoundException(
    override val message: String?,
) : NotFoundException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상점 정보가 존재하지 않습니다.";
    }
}