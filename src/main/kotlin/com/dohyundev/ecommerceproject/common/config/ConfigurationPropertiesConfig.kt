package com.dohyundev.ecommerceproject.common.config

import com.dohyundev.ecommerceproject.domain.auth.TokenProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = [
    TokenProperties::class
])
class ConfigurationPropertiesConfig {
}