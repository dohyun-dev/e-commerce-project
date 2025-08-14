package com.dohyundev.ecommerceproject.domain.auth

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "token")
data class TokenProperties(
    val secret: String,
    val accessTokenExpirationMs: Long,
    val refreshExpirationMs: Long
)