package com.dohyundev.ecommerceproject.master.api

import com.dohyundev.ecommerceproject.master.application.MasterServiceV1
import com.dohyundev.ecommerceproject.master.api.dto.MasterRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/masters")
class MasterApiControllerV1(
    private val masterService: MasterServiceV1
) {
    @PutMapping
    fun create(
        @RequestBody request: MasterRequest.Command
    ): ResponseEntity<Void> {

        masterService.register(
            code = request.code,
            valueType = request.valueType,
            value = request.value
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .build()
    }
}