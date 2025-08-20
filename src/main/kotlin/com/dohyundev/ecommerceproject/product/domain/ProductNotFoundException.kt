package com.dohyundev.ecommerceproject.product.domain

import com.dohyundev.ecommerceproject.common.exception.NotFoundException

class ProductNotFoundException(
    override val message: String?,
) : NotFoundException(message) {
    constructor() : this(DEFAULT_MESSAGE)

    companion object {
        private const val DEFAULT_MESSAGE = "상품이 존재하지 않습니다.";
    }
}