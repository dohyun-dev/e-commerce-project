package com.dohyundev.ecommerceproject.domain.product

import BaseEntity
import jakarta.persistence.*

@Entity
class ProductVariant(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id")
    var product: Product? = null,

    val sku: String
) : BaseEntity() {
    @OneToMany(mappedBy = "productVariant", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    val conditions: MutableSet<ProductVariantOptionCondition> = mutableSetOf()

    companion object {
        fun create(product: Product, sku: String, options: List<ProductOption>): ProductVariant {
            val variant = ProductVariant(
                product = product,
                sku = sku
            ).apply {
                val conditions = options.map {
                    ProductVariantOptionCondition(
                        variant = this,
                        option = it
                    )
                }
                this.conditions.addAll(conditions)
            }
            return variant
        }
    }
}