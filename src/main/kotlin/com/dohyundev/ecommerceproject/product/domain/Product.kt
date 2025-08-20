package com.dohyundev.ecommerceproject.product.domain

import BaseEntity
import com.dohyundev.ecommerceproject.product.domain.option_group.ProductOptionGroup
import com.dohyundev.ecommerceproject.product.domain.variant.ProductVariant
import com.dohyundev.ecommerceproject.shop.domain.Shop
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
    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    val optionGroups: MutableList<ProductOptionGroup> = mutableListOf()

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    val variants: MutableList<ProductVariant> = mutableListOf()
}