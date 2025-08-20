package com.dohyundev.ecommerceproject.auth.domain

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "token")
data class TokenProperties(
    val secret: String,
    val accessTokenExpirationMs: Long,
    val refreshExpirationMs: Long
)