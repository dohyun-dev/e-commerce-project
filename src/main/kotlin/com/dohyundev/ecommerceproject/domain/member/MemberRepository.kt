package com.dohyundev.ecommerceproject.domain.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUsername(username: String): Optional<Member>
}