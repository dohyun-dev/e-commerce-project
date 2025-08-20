package com.dohyundev.ecommerceproject.product.api.dto

interface ProductVariantRequest {
    data class Create(
        val sku: String,
        val optionIds: List<Long>,
    ) {

    }
}