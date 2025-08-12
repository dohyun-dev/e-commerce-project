package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
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
