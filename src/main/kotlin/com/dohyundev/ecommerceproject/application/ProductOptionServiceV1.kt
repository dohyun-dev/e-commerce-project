package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductOptionServiceV1(
    private val productOptionRepository: ProductOptionRepository,
    private val productOptionGroupRepository: ProductOptionGroupRepository
) {
    @Transactional
    fun create(productOptionId: Long, name: String) {
        val productOptionGroup = productOptionGroupRepository.findEntity(productOptionId)
        val newProductOptionGroup = ProductOption(name = name, productOptionGroup = productOptionGroup)
        productOptionRepository.save(newProductOptionGroup)
    }
}