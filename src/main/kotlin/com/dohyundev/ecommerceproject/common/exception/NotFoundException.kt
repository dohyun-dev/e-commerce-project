package com.dohyundev.ecommerceproject.common.exception

class NotFoundException(
    override val message: String?,
) : RuntimeException(message) {
    constructor() : this(null)
}