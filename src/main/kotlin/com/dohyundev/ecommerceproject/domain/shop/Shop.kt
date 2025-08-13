package com.dohyundev.ecommerceproject.domain.shop

import BaseEntity
import jakarta.persistence.Entity

@Entity
class Shop(
    val name: String,
) : BaseEntity() {
}