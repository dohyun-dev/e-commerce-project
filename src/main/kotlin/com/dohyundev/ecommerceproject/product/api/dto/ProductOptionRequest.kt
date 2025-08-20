package com.dohyundev.ecommerceproject.product.api.dto

interface ProductOptionRequest {
    data class Create(
        val name: String
    ) {

    }
}