package com.dohyundev.ecommerceproject.auth.api.dto

interface AuthRequest {
    class Login(
        val username: String,
        val password: String
    ) {
    }
}