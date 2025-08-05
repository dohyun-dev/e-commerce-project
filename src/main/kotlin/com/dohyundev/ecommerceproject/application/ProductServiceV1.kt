package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.Product
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class ProductServiceV1(
    private val productRepository: ProductRepository
) {
    @Transactional
    fun create(name: String, price: BigDecimal) {
        val newProduct = Product(name = name, price = price)
        productRepository.save(newProduct)
    }
}