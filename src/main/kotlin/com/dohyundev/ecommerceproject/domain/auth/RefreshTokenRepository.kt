package com.dohyundev.ecommerceproject.domain.auth

import org.springframework.data.repository.CrudRepository
import java.util.*

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long> {
    fun findByToken(token: String): Optional<RefreshToken>
}