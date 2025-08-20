package com.dohyundev.ecommerceproject.auth.domain

data class TokenPair(
    val accessToken: String,
    val refreshToken: String
)