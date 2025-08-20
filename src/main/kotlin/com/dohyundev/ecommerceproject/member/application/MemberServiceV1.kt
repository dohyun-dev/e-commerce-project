package com.dohyundev.ecommerceproject.member.application

import com.dohyundev.ecommerceproject.member.domain.DuplicatedUsernameException
import com.dohyundev.ecommerceproject.member.domain.Member
import com.dohyundev.ecommerceproject.member.domain.MemberRepository
import com.dohyundev.ecommerceproject.member.domain.Password
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