package com.dohyundev.ecommerceproject.product.api.dto

interface ProductOptionGroupRequest {
    data class Create(
        val shopId: String,
        val name: String
    ) {

    }
}