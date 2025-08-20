package com.dohyundev.ecommerceproject.common.dto

import org.springframework.data.domain.Page

data class PageResponse<T>(
    val currentPage: Long,
    val totalPages: Long,
    val totalElements: Long,
    val items: List<T>,
    val hasPrevious: Boolean,
    val hasNext: Boolean,
) {
    companion object {
        fun <T> fromPage(page: Page<T>): PageResponse<T> {
            return PageResponse(
                currentPage = page.number.toLong(),
                totalPages = page.totalPages.toLong(),
                totalElements = page.totalElements,
                items = page.content,
                hasPrevious = page.hasPrevious(),
                hasNext = page.hasNext()
            )
        }
    }
}
