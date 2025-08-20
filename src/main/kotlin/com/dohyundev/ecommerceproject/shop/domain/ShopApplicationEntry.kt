package com.dohyundev.ecommerceproject.shop.domain

import BaseEntity
import jakarta.persistence.Entity

@Entity
class ShopApplicationEntry(
    var shopName: String,
    var businessNumber: String,
    var mailOrderNumber: String,
    var businessType: String,
    var businessItem: String,
    var managerName: String,
    var managerEmail: String,
    var managerPhoneNumber: String,
) : BaseEntity() {
}