package com.dohyundev.ecommerceproject.domain.product.option

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {
}