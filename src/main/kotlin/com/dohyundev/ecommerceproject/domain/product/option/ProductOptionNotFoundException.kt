package com.dohyundev.ecommerceproject.domain.product.option

class ProductOptionNotFoundException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상품 옵션이 존재하지 않습니다.";
    }
}