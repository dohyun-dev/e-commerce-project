package com.dohyundev.ecommerceproject.shop.application

import com.dohyundev.ecommerceproject.shop.domain.Shop
import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntryRepository
import com.dohyundev.ecommerceproject.shop.domain.ShopRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ShopServiceV1(
    private val shopRepository: ShopRepository,
    private val shopApplicationEntryRepository: ShopApplicationEntryRepository
) {
    @Transactional
    fun create(name: String): Long? {
        val newShop = Shop(name = name)
        return shopRepository.save(newShop).id!!
    }
}