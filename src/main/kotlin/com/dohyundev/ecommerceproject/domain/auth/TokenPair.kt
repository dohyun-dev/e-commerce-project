package com.dohyundev.ecommerceproject.domain.auth

data class TokenPair(
    val accessToken: String,
    val refreshToken: String
)