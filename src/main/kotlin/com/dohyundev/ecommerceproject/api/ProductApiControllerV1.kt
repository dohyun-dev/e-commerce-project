package com.dohyundev.ecommerceproject.api

import com.dohyundev.ecommerceproject.api.dto.ProductOptionGroupRequest
import com.dohyundev.ecommerceproject.api.dto.ProductOptionRequest
import com.dohyundev.ecommerceproject.api.dto.ProductRequest
import com.dohyundev.ecommerceproject.application.ProductOptionGroupServiceV1
import com.dohyundev.ecommerceproject.application.ProductServiceV1
import com.dohyundev.ecommerceproject.domain.product.ProductOptionGroup
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ProductApiControllerV1(
    private val productService: ProductServiceV1,
    private val productOptionGroupService: ProductOptionGroupServiceV1
) {

    @PostMapping("/products")
    fun createProduct(
        @RequestBody request: ProductRequest.Create
    ) : ResponseEntity<Void> {
        productService.create(request.name, request.price);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product-option-groups")
    fun createProductOptionGroup(
        @RequestBody request: ProductOptionGroupRequest.Create
    ) : ResponseEntity<Void> {
        productOptionGroupService.create(request.productId, request.name)
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product-option")
    fun createProductOption(
        @RequestBody request: ProductOptionRequest.Create
    ) : ResponseEntity<Void> {

        return ResponseEntity.ok().build();
    }
}