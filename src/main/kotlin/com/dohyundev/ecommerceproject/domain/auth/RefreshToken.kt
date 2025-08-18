package com.dohyundev.ecommerceproject.domain.auth

import BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime
import java.time.ZoneId

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(name = "uc_refreshtoken_token", columnNames = ["token"])
    ]
)
class RefreshToken(
    @Column(name = "token", nullable = false)
    val token: String,
    val expiredAt: LocalDateTime,
) : BaseEntity() {

    companion object {
        fun create(tokenPair: TokenPair, tokenUtil: TokenUtil): RefreshToken {
            val refreshToken = tokenPair.refreshToken

            val expiration = tokenUtil.getExpiration(refreshToken)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()

            return RefreshToken(
                token = refreshToken,
                expiredAt = expiration
            )
        }
    }
}