package com.dohyundev.ecommerceproject.shop.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ShopApplicationEntryRepository : JpaRepository<ShopApplicationEntry, Long> {
}