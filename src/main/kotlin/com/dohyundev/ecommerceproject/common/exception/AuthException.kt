package com.dohyundev.ecommerceproject.common.exception

open class AuthException(
    override val message: String?,
) : BusinessException(message) {
}