package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import com.dohyundev.ecommerceproject.domain.shop.Shop
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Product(
    var name: String,

    var price: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_id",
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    var shop: Shop? = null,
) : BaseEntity() {
}