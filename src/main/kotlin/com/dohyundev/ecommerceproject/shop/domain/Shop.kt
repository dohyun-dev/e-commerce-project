package com.dohyundev.ecommerceproject.shop.domain

import BaseEntity
import jakarta.persistence.Entity

@Entity
class Shop(
    val name: String,
) : BaseEntity() {
}