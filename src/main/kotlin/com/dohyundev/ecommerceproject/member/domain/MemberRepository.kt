package com.dohyundev.ecommerceproject.member.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUsername(username: String): Optional<Member>


    @Query("select (count(m) > 0) from Member m where m.username = :username")
    fun existsByUsername(username: String): Boolean
}