package com.dohyundev.ecommerceproject.product.domain.variant

import org.springframework.data.jpa.repository.JpaRepository

interface ProductVariantRepository : JpaRepository<ProductVariant, Long> {
}