package com.dohyundev.ecommerceproject.common.exception

open class NotFoundException(
    override val message: String?,
) : BusinessException(message) {
}