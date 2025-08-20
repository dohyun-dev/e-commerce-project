package com.dohyundev.ecommerceproject.auth.domain

import org.springframework.data.repository.CrudRepository
import java.util.*

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long> {
    fun findByToken(token: String): Optional<RefreshToken>
}