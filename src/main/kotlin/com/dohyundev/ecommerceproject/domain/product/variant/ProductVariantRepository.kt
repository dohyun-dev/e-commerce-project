package com.dohyundev.ecommerceproject.domain.product.variant

import org.springframework.data.jpa.repository.JpaRepository

interface ProductVariantRepository : JpaRepository<ProductVariant, Long> {
}