package com.dohyundev.ecommerceproject.product.domain.option

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class ProductOptionNotFoundException(
    override val message: String?,
) : NotFoundException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상품 옵션이 존재하지 않습니다.";
    }
}