package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.common.exception.BusinessException
import com.dohyundev.ecommerceproject.domain.product.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductVariantServiceV1(
    val productRepository: ProductRepository,
    val productOptionRepository: ProductOptionRepository,
    val productVariantRepository: ProductVariantRepository
) {
    @Transactional
    fun create(
        productId: Long,
        sku: String,
        productOptionIds: List<Long>
    ): Long {
        val product = productRepository.findById(productId)
            .orElseThrow { ProductNotFoundException() }

        val productOptions = productOptionRepository.findAllById(productOptionIds)

        if (productOptionIds.size != productOptions.size) {
            throw BusinessException("옵션 정보가 존재하지 않습니다.")
        }

        val productVariant = ProductVariant.create(
            product = product,
            sku = sku,
            options = productOptions
        )

        return productVariantRepository.save(productVariant).id!!
    }
}