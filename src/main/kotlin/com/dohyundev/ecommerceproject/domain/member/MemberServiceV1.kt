package com.dohyundev.ecommerceproject.domain.member

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MemberServiceV1(
    private val repository: MemberRepository,
) {

    @Transactional
    fun create(username: String, password: Password) : Long {
        val newMember = Member(
            username = username,
            password = password,
        );
        return repository.save(newMember).id!!
    }
}