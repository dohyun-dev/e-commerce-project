package com.dohyundev.ecommerceproject.domain.product.option

import BaseEntity
import com.dohyundev.ecommerceproject.domain.product.option_group.ProductOptionGroup
import jakarta.persistence.*

@Entity
class ProductOption(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_OPTION_GROUP_ID")
    var productOptionGroup: ProductOptionGroup? = null,

    var name: String,

    @Column(nullable = false)
    var priority: Int = 0,
) : BaseEntity() {
}