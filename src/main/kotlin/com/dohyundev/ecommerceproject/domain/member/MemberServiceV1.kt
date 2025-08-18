package com.dohyundev.ecommerceproject.domain.member

import com.dohyundev.ecommerceproject.domain.master.DuplicatedUsernameException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MemberServiceV1(
    private val repository: MemberRepository,
) {

    @Transactional
    fun create(username: String, password: Password) : Long {
        if (repository.existsByUsername(username))
            throw DuplicatedUsernameException()

        val newMember = Member(
            username = username,
            password = password,
        );

        return repository.save(newMember).id!!
    }
}