package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.Product
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductServiceV1(
    private val productRepository: ProductRepository
) {
    fun create(name: String, price: BigDecimal) {
        val newProduct = Product(name = name, price = price)
        productRepository.save(newProduct)
    }
}