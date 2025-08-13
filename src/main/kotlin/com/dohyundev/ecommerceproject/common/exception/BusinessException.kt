package com.dohyundev.ecommerceproject.common.exception

open class BusinessException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(null)
}