package com.dohyundev.ecommerceproject.presentation.api.dto

interface ShopRequest {
    data class Create(
        var name: String
    )
}