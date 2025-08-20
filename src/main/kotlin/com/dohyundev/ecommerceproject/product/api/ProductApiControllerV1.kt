package com.dohyundev.ecommerceproject.product.api

import com.dohyundev.ecommerceproject.product.api.dto.ProductOptionGroupRequest
import com.dohyundev.ecommerceproject.product.api.dto.ProductOptionRequest
import com.dohyundev.ecommerceproject.product.api.dto.ProductRequest
import com.dohyundev.ecommerceproject.product.application.ProductOptionGroupServiceV1
import com.dohyundev.ecommerceproject.product.application.ProductOptionServiceV1
import com.dohyundev.ecommerceproject.product.application.ProductServiceV1
import com.dohyundev.ecommerceproject.product.application.ProductVariantServiceV1
import com.dohyundev.ecommerceproject.product.api.dto.ProductVariantRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductApiControllerV1(
    private val productService: ProductServiceV1,
    private val productOptionGroupService: ProductOptionGroupServiceV1,
    private val productOptionService: ProductOptionServiceV1,
    private val productVariantService: ProductVariantServiceV1
) {
    @PostMapping
    fun createProduct(
        @RequestBody request: ProductRequest.Create
    ) : ResponseEntity<Long> {
        val newProductId = productService.create(request.shopId, request.name, request.price);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductId)
    }

    @PostMapping("/{productId}/option-groups")
    fun createProductOptionGroup(
        @PathVariable productId: Long,
        @RequestBody request: ProductOptionGroupRequest.Create
    ) : ResponseEntity<Long> {
        val newProductOptionGroupId = productOptionGroupService.create(productId, request.name)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductOptionGroupId)
    }

    @PostMapping("/{productId}/option-groups/{optionGroupId}/options")
    fun createProductOption(
        @PathVariable optionGroupId: Long,
        @RequestBody request: ProductOptionRequest.Create
    ) : ResponseEntity<Long> {
        val newProductOptionGroupId = productOptionService.create(
            optionGroupId,
            request.name
        )
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductOptionGroupId)
    }

    @PostMapping("/{productId}/variants")
    fun createProductVariant(
        @PathVariable productId: Long,
        @RequestBody request: ProductVariantRequest.Create
    ) : ResponseEntity<Long> {
        val newProductVariantId = productVariantService.create(
            productId,
            request.sku,
            request.optionIds
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductVariantId)
    }
}