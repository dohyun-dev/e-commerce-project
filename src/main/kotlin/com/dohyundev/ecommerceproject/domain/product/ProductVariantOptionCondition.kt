package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(name = "uk_variant_option_condition", columnNames = ["product_variant_id", "product_option_id"])
    ]
)
class ProductVariantOptionCondition(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id")
    var variant: ProductVariant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id")
    var option: ProductOption? = null
) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductVariantOptionCondition) return false

        if (variant != other.variant) return false
        if (option != other.option) return false

        return true
    }

    override fun hashCode(): Int {
        var result = variant?.hashCode() ?: 0
        result = 31 * result + (option?.hashCode() ?: 0)
        return result
    }
}