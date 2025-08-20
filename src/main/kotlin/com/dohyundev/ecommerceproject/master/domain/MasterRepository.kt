package com.dohyundev.ecommerceproject.master.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface MasterRepository : JpaRepository<Master, Long> {
    @Query("select (count(m) > 0) from Master m where m.code = :code")
    fun existsByCode(code: String): Boolean

    @Query("select m from Master m where m.code = :code")
    fun findByCode(code: String): Optional<Master>

}