package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

@Entity
class Product(
    var name: String,
    var price: BigDecimal
) : BaseEntity() {
}