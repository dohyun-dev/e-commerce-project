package com.dohyundev.ecommerceproject.presentation.api

import com.dohyundev.ecommerceproject.domain.member.MemberServiceV1
import com.dohyundev.ecommerceproject.presentation.api.dto.MemberRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberApiControllerV1(
    private val memberService: MemberServiceV1
) {
    @PostMapping
    fun create(
        @RequestBody request: MemberRequest.Create
    ) : ResponseEntity<Long> {
        val newMemberId = memberService.create(
            username = request.username,
            password = request.toPassword()
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newMemberId);
    }
}