package com.dohyundev.ecommerceproject.shop.api

import com.dohyundev.ecommerceproject.shop.api.dto.ShopRequest
import com.dohyundev.ecommerceproject.shop.application.ShopServiceV1
import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/shops")
@Transactional
class ShopApiControllerV1(
    private val shopService: ShopServiceV1,
) {
    @PostMapping
    fun create(
        @RequestBody request: ShopRequest.Create
    ): ResponseEntity<Long> {
        val shopId = shopService.create(request.name)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(shopId)
    }
}