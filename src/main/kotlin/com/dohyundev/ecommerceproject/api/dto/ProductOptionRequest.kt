package com.dohyundev.ecommerceproject.api.dto

interface ProductOptionRequest {
    data class Create(
        val productOptionId: Long,
        val name: String
    ) {

    }
}