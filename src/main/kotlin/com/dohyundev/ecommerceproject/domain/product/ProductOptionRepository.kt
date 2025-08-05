package com.dohyundev.ecommerceproject.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {
    fun findEntity(id: Long): ProductOption = findById(id).orElseThrow { ProductOptionNotFoundException() }
}