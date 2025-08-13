package com.dohyundev.ecommerceproject.presentation.api.dto

interface ProductVariantRequest {
    data class Create(
        val sku: String,
        val optionIds: List<Long>,
    ) {

    }
}