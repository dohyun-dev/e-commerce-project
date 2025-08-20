package com.dohyundev.ecommerceproject.auth.domain

import com.dohyundev.ecommerceproject.member.domain.MemberNotFoundException
import com.dohyundev.ecommerceproject.member.domain.MemberRepository
import com.dohyundev.ecommerceproject.member.domain.Password
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AuthServiceV1(
    private val memberRepository: MemberRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val tokenFactory: TokenFactory,
    private val tokenUtil: TokenUtil,
) {
    @Transactional
    fun login(username: String, password: Password): TokenPair {
        val member = memberRepository.findByUsername(username)
            .orElseThrow { LoginFailureException() }

        if (member.password != password) {
            throw LoginFailureException()
        }

        val tokenPair = tokenFactory.generateTokenPair(member)

        val refreshTokenEntity = RefreshToken.create(tokenPair, tokenUtil)

        refreshTokenRepository.save(refreshTokenEntity)

        return tokenPair;
    }

    @Transactional
    fun reissue(refreshToken: String): TokenPair {
        if (tokenUtil.isExpired(refreshToken)) {
            throw InvalidTokenException("장기간 미접속으로 로그아웃 되었습니다.")
        }

        val storedToken = refreshTokenRepository.findByToken(refreshToken)
            .orElseThrow { InvalidTokenException() }
        
        val memberId = tokenUtil.getSubject(refreshToken).toLong()

        val member = memberRepository.findById(memberId)
            .orElseThrow { MemberNotFoundException() }

        val newPair = tokenFactory.generateTokenPair(member)

        refreshTokenRepository.save(RefreshToken.create(newPair, tokenUtil))

        refreshTokenRepository.delete(storedToken)

        return newPair
    }

    @Transactional
    fun logout(refreshToken: String) {
        val storedToken = refreshTokenRepository.findByToken(refreshToken)
            .orElseThrow { InvalidTokenException() }

        refreshTokenRepository.delete(storedToken)
    }
}

