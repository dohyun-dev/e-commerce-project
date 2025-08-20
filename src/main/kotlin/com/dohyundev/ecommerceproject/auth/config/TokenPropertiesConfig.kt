package com.dohyundev.ecommerceproject.auth.config

import com.dohyundev.ecommerceproject.auth.domain.TokenProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = [
    TokenProperties::class
])
class TokenPropertiesConfig {
}