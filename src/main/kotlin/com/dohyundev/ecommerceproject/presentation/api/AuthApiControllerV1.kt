package com.dohyundev.ecommerceproject.presentation.api

import com.dohyundev.ecommerceproject.domain.auth.AuthServiceV1
import com.dohyundev.ecommerceproject.domain.auth.TokenPair
import com.dohyundev.ecommerceproject.domain.auth.TokenProperties
import com.dohyundev.ecommerceproject.domain.member.Password
import com.dohyundev.ecommerceproject.presentation.api.dto.AuthRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Duration

@RestController
@RequestMapping("/api/v1/auth")
class AuthApiControllerV1(
    private val authService: AuthServiceV1,
    private val tokenProperties: TokenProperties
) {
    @PostMapping("/login")
    fun login(
        @RequestBody request: AuthRequest.Login,
        httpServletResponse: HttpServletResponse
    ) : ResponseEntity<String> {
        val tokenPair: TokenPair = authService.login(
            username = request.username,
            password = Password.create(request.password)
        )

        val refreshTokenCookie = ResponseCookie.from(REFRESH_COOKIE_NAME, tokenPair.refreshToken)
            .httpOnly(true)
            .secure(REFRESH_COOKIE_SECURE)
            .maxAge(Duration.ofMillis(tokenProperties.refreshExpirationMs))
            .build()

        return ResponseEntity
            .status(HttpStatus.OK)
            .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
            .body(tokenPair.accessToken) // 액세스 토큰은 바디로 반환
    }

    @PostMapping("/reissue")
    fun reissue(
        @CookieValue(name = "refreshToken", required = false) refreshToken: String?
    ): ResponseEntity<String> {
        if (refreshToken.isNullOrBlank()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("장기간 미접속으로 로그아웃 되었습니다.")
        }

        val newPair = authService.reissue(refreshToken)

        val newRefreshCookie = ResponseCookie.from(REFRESH_COOKIE_NAME, newPair.refreshToken)
            .httpOnly(true)
            .secure(REFRESH_COOKIE_SECURE)
            .maxAge(Duration.ofMillis(tokenProperties.refreshExpirationMs))
            .build()

        return ResponseEntity
            .status(HttpStatus.OK)
            .header(HttpHeaders.SET_COOKIE, newRefreshCookie.toString())
            .body(newPair.accessToken)
    }

    companion object {
        private val REFRESH_COOKIE_NAME = "refreshToken"
        private val REFRESH_COOKIE_SECURE = false
    }
}
