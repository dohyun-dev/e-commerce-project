package com.dohyundev.ecommerceproject.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findEntity(id: Long): Product = findById(id).orElseThrow { ProductNotFoundException() }
}