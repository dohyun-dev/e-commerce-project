package com.dohyundev.ecommerceproject.product.domain.option_group

import BaseEntity
import com.dohyundev.ecommerceproject.product.domain.Product
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class ProductOptionGroup(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product? = null,

    var name: String,

    var priority: Int = 0,
) : BaseEntity() {
}
