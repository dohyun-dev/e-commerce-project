package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

class ProductOption(
    var name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_OPTION_GROUP_ID")
    var ProductOptionGroup: ProductOptionGroup? = null
) : BaseEntity() {

}