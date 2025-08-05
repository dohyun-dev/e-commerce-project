package com.dohyundev.ecommerceproject.api.dto

interface ProductOptionGroupRequest {
    data class Create(
        val productId: Long,
        val name: String
    ) {

    }
}