package com.dohyundev.ecommerceproject.shop.api.dto

interface ShopRequest {
    data class Create(
        var name: String
    )

    data class Apply(
        val shopName: String,
        val businessNumber: String,
        val mailOrderNumber: String,
        val businessType: String,
        val businessItem: String,
        val managerName: String,
        val managerEmail: String,
        val managerPhoneNumber: String,
    )
}