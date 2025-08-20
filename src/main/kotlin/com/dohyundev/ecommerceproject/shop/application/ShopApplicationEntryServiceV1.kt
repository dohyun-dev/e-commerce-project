package com.dohyundev.ecommerceproject.shop.application

import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntry
import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ShopApplicationEntryServiceV1(
    private val shopApplicationEntryRepository: ShopApplicationEntryRepository
) {
    @Transactional
    fun applyForShop(
        shopName: String,
        businessNumber: String,
        mailOrderNumber: String,
        businessType: String,
        businessItem: String,
        managerName: String,
        managerEmail: String,
        managerPhoneNumber: String,
        managerTel: String? = null
    ): Long {
        val entry = ShopApplicationEntry(
            shopName = shopName,
            businessNumber = businessNumber,
            mailOrderNumber = mailOrderNumber,
            businessType = businessType,
            businessItem = businessItem,
            managerName = managerName,
            managerEmail = managerEmail,
            managerPhoneNumber = managerPhoneNumber,
        )
        return shopApplicationEntryRepository.save(entry).id!!
    }
}