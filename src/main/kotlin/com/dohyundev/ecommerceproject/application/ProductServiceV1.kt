package com.dohyundev.ecommerceproject.application

import com.dohyundev.ecommerceproject.domain.product.Product
import com.dohyundev.ecommerceproject.domain.product.ProductRepository
import com.dohyundev.ecommerceproject.domain.shop.ShopNotFoundException
import com.dohyundev.ecommerceproject.domain.shop.ShopRepository
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
            .orElseThrow { ShopNotFoundException() }

        val newProduct = Product(
            name = name,
            price = BigDecimal(price),
            shop = shop
        )

        return productRepository.save(newProduct).id!!
    }
}