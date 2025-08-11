package com.dohyundev.ecommerceproject.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionGroupRepository : JpaRepository<ProductOptionGroup, Long> {
}