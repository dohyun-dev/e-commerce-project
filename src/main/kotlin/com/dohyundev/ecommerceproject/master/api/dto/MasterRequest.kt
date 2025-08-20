package com.dohyundev.ecommerceproject.master.api.dto

import com.dohyundev.ecommerceproject.master.domain.Master

interface MasterRequest {
    data class Command(
        val code: String,
        val valueType: Master.ValueType,
        val value: String,
    ) {

    }
}