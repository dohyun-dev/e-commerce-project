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
    fun create(
        productOptionGroupId: Long,
        name: String
    ) : Long? {
        val productOptionGroup = productOptionGroupRepository.findById(productOptionGroupId)
            .orElseThrow { ProductOptionGroupNotFoundException() }

        val newProductOptionGroup = ProductOption(name = name, productOptionGroup = productOptionGroup)

        return productOptionRepository.save(newProductOptionGroup).id
    }
}