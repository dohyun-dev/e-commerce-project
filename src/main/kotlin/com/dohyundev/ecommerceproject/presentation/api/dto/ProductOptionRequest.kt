package com.dohyundev.ecommerceproject.presentation.api.dto

interface ProductOptionRequest {
    data class Create(
        val productOptionGroupId: Long,
        val name: String
    ) {

    }
}