package com.dohyundev.ecommerceproject.common.exception

class BusinessException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(null)
}