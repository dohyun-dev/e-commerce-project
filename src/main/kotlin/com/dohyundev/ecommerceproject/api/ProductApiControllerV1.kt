package com.dohyundev.ecommerceproject.api

import com.dohyundev.ecommerceproject.api.dto.ProductRequest
import com.dohyundev.ecommerceproject.application.ProductServiceV1
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductApiControllerV1(
    private val productService: ProductServiceV1
) {

    @PostMapping
    fun createProduct(
        @RequestBody request: ProductRequest.Create
    ) : ResponseEntity<Void> {
        productService.create(request.name, request.price);
        return ResponseEntity.ok().build();
    }
}