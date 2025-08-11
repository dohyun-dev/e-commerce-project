package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.math.BigDecimal

@Entity
class ProductVariant(
    val sku: String,
    var price: BigDecimal,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id")
    var product: Product? = null,
    var stockQuantity: Int? = null
) : BaseEntity() {
}