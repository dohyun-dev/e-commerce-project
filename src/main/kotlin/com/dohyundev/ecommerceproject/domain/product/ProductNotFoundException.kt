package com.dohyundev.ecommerceproject.domain.product

class ProductNotFoundException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상품정보가 존재하지 않습니다.";
    }
}