package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.ProductNotFoundException
import com.dohyundev.ecommerceproject.domain.product.option_group.ProductOptionGroup
import com.dohyundev.ecommerceproject.domain.product.option_group.ProductOptionGroupRepository
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductOptionGroupServiceV1(
    private val productOptionGroupRepository: ProductOptionGroupRepository,
    private val productRepository: ProductRepository
) {
    @Transactional
    fun create(productId: Long, name: String): Long? {
        val product = productRepository.findById(productId)
            .orElseThrow { ProductNotFoundException() }
        val newProductOptionGroup = ProductOptionGroup(name = name, product = product)

        return productOptionGroupRepository.save(newProductOptionGroup).id!!
    }


}