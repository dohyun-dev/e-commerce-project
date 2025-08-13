package com.dohyundev.ecommerceproject.domain.shop

class ShopNotFoundException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상점 정보가 존재하지 않습니다.";
    }
}