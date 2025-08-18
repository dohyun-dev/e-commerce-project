package com.dohyundev.ecommerceproject.domain.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class TokenUtil(
    val properties: TokenProperties
) {
    private val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(properties.secret))

    fun parseClaims(token: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (ex: ExpiredJwtException) {
            ex.claims
        } catch (ex: Exception) {
            throw InvalidTokenException()
        }
    }

    fun isExpired(token: String): Boolean {
        val exp = parseClaims(token).expiration
        return exp.before(Date())
    }

    fun getSubject(token: String): String {
        return parseClaims(token).subject
    }

    fun getTokenId(token: String): String {
        return parseClaims(token).id
    }

    fun getExpiration(token: String): Date {
        return parseClaims(token).expiration
    }


    /**
     * 만료 시간을 특정 시간 단위로 반환
     */
    fun getExpiration(token: String, unit: ChronoUnit): Long {
        val expirationDate = parseClaims(token).expiration
        val ldt = expirationDate.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()

        return when (unit) {
            ChronoUnit.MILLIS -> expirationDate.time
            ChronoUnit.SECONDS -> expirationDate.time / 1000
            ChronoUnit.MINUTES -> expirationDate.time / 1000 / 60
            ChronoUnit.HOURS -> expirationDate.time / 1000 / 60 / 60
            ChronoUnit.DAYS -> expirationDate.time / 1000 / 60 / 60 / 24
            else -> throw IllegalArgumentException("지원하지 않는 시간 단위: $unit")
        }
    }
}
