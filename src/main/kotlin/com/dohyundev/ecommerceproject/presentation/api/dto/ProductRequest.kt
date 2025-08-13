package com.dohyundev.ecommerceproject.presentation.api.dto

interface ProductRequest {
    data class Create(
        val shopId: Long,
        val name: String,
        val price: Long,
    ) {

    }
}