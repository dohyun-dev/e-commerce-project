package com.dohyundev.ecommerceproject.api.dto

import java.math.BigDecimal

interface ProductRequest {
    data class Create(
        val name: String,
        val price: BigDecimal,
    )
}