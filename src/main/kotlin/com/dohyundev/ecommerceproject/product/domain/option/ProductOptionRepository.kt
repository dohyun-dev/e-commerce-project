package com.dohyundev.ecommerceproject.product.domain.option

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {
}