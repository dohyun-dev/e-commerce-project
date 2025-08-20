package com.dohyundev.ecommerceproject.shop.api

import com.dohyundev.ecommerceproject.common.dto.PageResponse
import com.dohyundev.ecommerceproject.shop.api.dto.ShopRequest
import com.dohyundev.ecommerceproject.shop.application.ShopApplicationEntryServiceV1
import com.dohyundev.ecommerceproject.shop.application.ShopServiceV1
import com.dohyundev.ecommerceproject.shop.domain.Shop
import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntry
import com.dohyundev.ecommerceproject.shop.domain.ShopApplicationEntryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/shop-application-entries")
@Transactional
class ShopApplicationEntryApiControllerV1(
    private val shopApplicationEntryService: ShopApplicationEntryServiceV1,
    private val shopApplicationEntryRepository: ShopApplicationEntryRepository
) {
    @GetMapping
    fun getApplies(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int,

    ) : ResponseEntity<PageResponse<ShopApplicationEntry>> {
        val applies = shopApplicationEntryRepository.findAll(PageRequest.of(
            page,
            size,
            Sort.by(Sort.Direction.DESC, "id")
        ))

        return ResponseEntity.ok(
            PageResponse.fromPage(applies)
        )
    }

    @PostMapping
    fun applyForShop(
        @RequestBody request: ShopRequest.Apply
    ): ResponseEntity<Long> {
        val entryId = shopApplicationEntryService.applyForShop(
            shopName = request.shopName,
            businessNumber = request.businessNumber,
            mailOrderNumber = request.mailOrderNumber,
            businessType = request.businessType,
            businessItem = request.businessItem,
            managerName = request.managerName,
            managerEmail = request.managerEmail,
            managerPhoneNumber = request.managerPhoneNumber,
        )

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(entryId)
    }
}