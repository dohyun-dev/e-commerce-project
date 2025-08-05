package com.dohyundev.ecommerceproject.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionGroupRepository : JpaRepository<ProductOptionGroup, Long> {
    fun findEntity(id: Long): ProductOptionGroup = findById(id).orElseThrow { ProductOptionGroupNotFoundException() }
}