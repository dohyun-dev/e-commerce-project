package com.dohyundev.ecommerceproject.presentation.api.dto

interface AuthRequest {
    class Login(
        val username: String,
        val password: String
    ) {
    }
}