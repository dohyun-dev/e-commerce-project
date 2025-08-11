package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.Product
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import com.dohyundev.ecommerceproject.domain.shop.ShopRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class ProductServiceV1(
    private val shopRepository: ShopRepository,
    private val productRepository: ProductRepository
) {
    @Transactional
    fun create(shopId: Long, name: String, price: Long): Long? {
        val shop = shopRepository.findById(shopId)
            .orElseThrow { EntityNotFoundException() }

        val newProduct = Product(
            name = name,
            price = BigDecimal(price),
            shop = shop
        )

        return productRepository.save(newProduct).id
    }
}