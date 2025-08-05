package com.dohyundev.ecommerceproject.domain.product

class ProductOptionGroupNotFoundException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상품 옵션 그룹이 존재하지 않습니다.";
    }
}