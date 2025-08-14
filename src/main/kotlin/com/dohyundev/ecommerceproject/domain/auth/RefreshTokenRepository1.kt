package com.dohyundev.ecommerceproject.domain.auth

import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository1 : JpaRepository<RefreshToken, Long> {
}