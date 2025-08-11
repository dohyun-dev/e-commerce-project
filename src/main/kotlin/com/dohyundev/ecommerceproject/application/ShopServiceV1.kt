package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.shop.Shop
import com.dohyundev.ecommerceproject.domain.shop.ShopRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ShopServiceV1(
    private val shopRepository: ShopRepository,
) {
    @Transactional
    fun create(name: String): Long? {
        val newShop = Shop(name = name)
        return shopRepository.save(newShop).id
    }
}