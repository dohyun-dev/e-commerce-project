package com.dohyundev.ecommerceproject.auth.domain

import com.dohyundev.ecommerceproject.member.domain.Member
import com.github.f4b6a3.tsid.TsidCreator
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenFactory(
    private val properties: TokenProperties
) {
    private val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(properties.secret))

    fun generateTokenPair(member: Member): TokenPair =
        TokenPair(
            accessToken = generateAccessToken(member),
            refreshToken = generateRefreshToken(member)
        )


    private fun generateAccessToken(member: Member): String {
        val now = Date()
        val exp = Date(now.time + properties.accessTokenExpirationMs)
        val subject = requireNotNull(member.id) { "member.id is null" }.toString()

        return Jwts.builder()
            .setId(TsidCreator.getTsid().toString())
            .setSubject(subject)
            .setIssuedAt(now)
            .setExpiration(exp)
            .addClaims(createClaims(member))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    private fun generateRefreshToken(member: Member): String {
        val now = Date()
        val exp = Date(now.time + properties.refreshExpirationMs)
        val subject = requireNotNull(member.id) { "member.id is null" }.toString()

        return Jwts.builder()
            .setId(TsidCreator.getTsid().toString())
            .setSubject(subject)
            .setIssuedAt(now)
            .setExpiration(exp)
            .addClaims(mapOf("token_type" to "refresh"))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun createClaims(member: Member): Map<String, Any?> {
        val claims = mapOf(
            "name" to member.name,
            "role" to member.role,
        )
        return claims
    }
}