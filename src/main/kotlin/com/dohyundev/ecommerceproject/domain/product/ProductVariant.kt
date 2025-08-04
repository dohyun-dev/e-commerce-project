package com.dohyundev.ecommerceproject.domain.product

import java.math.BigDecimal

class ProductVariant(
    val sku: String,
    var price: BigDecimal,
) {
}