package com.dohyundev.ecommerceproject.presentation.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestApiController {
    @GetMapping
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("test")
    }
}