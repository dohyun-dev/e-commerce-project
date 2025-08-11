package com.dohyundev.ecommerceproject.presentation.api.dto

interface ProductOptionGroupRequest {
    data class Create(
        val shopId: String,
        val productId: Long,
        val name: String
    ) {

    }
}