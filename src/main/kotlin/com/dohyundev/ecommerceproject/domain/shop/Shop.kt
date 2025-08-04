package com.dohyundev.ecommerceproject.domain.shop

import BaseEntity
import io.hypersistence.utils.hibernate.id.Tsid
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Shop(
    val name: String,
) : BaseEntity() {
}