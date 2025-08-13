package com.dohyundev.ecommerceproject.presentation.api.dto

import com.dohyundev.ecommerceproject.domain.master.Master

interface MasterRequest {
    data class Command(
        val code: String,
        val valueType: Master.ValueType,
        val value: String,
    ) {

    }
}