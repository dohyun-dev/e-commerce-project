package com.dohyundev.ecommerceproject.shop.api.dto

interface ShopRequest {
    data class Create(
        var name: String
    )
}