package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.ProductOptionGroup
import com.dohyundev.ecommerceproject.domain.product.ProductOptionGroupRepository
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductOptionGroupServiceV1(
    private val productOptionGroupRepository: ProductOptionGroupRepository,
    private val productRepository: ProductRepository
) {
    @Transactional
    fun create(productId: Long, name: String) {
        val product = productRepository.findEntity(productId)
        val newProductOptionGroup = ProductOptionGroup(name = name, product = product)
        productOptionGroupRepository.save(newProductOptionGroup)
    }


}