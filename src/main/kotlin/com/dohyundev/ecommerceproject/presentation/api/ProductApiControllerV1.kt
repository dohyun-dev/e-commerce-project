package com.dohyundev.ecommerceproject.presentation.api

import com.dohyundev.ecommerceproject.presentation.api.dto.ProductOptionGroupRequest
import com.dohyundev.ecommerceproject.presentation.api.dto.ProductOptionRequest
import com.dohyundev.ecommerceproject.presentation.api.dto.ProductRequest
import com.dohyundev.ecommerceproject.application.ProductOptionGroupServiceV1
import com.dohyundev.ecommerceproject.application.ProductOptionServiceV1
import com.dohyundev.ecommerceproject.application.ProductServiceV1
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ProductApiControllerV1(
    private val productService: ProductServiceV1,
    private val productOptionGroupService: ProductOptionGroupServiceV1,
    private val productOptionService: ProductOptionServiceV1
) {

    @PostMapping("/products")
    fun createProduct(
        @RequestBody request: ProductRequest.Create
    ) : ResponseEntity<Long> {
        val newProductId = productService.create(request.shopId, request.name, request.price);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductId)
    }

    @PostMapping("/product-option-groups")
    fun createProductOptionGroup(
        @RequestBody request: ProductOptionGroupRequest.Create
    ) : ResponseEntity<Long> {
        val newProductOptionGroupId = productOptionGroupService.create(request.productId, request.name)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductOptionGroupId)
    }

    @PostMapping("/product-options")
    fun createProductOption(
        @RequestBody request: ProductOptionRequest.Create
    ) : ResponseEntity<Long> {
        val newProductOptionGroupId = productOptionService.create(
            request.productOptionGroupId,
            request.name
        )
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProductOptionGroupId)
    }
}