package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class ProductVariant(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id")
    var product: Product? = null,

    val sku: String,

    var price: BigDecimal,
) : BaseEntity() {
    @OneToMany(mappedBy = "productVariant", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    val condition: MutableSet<ProductVariantOptionCondition> = mutableSetOf();
}