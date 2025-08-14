package com.dohyundev.ecommerceproject.presentation.config

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.util.StringUtils
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.resource.ResourceResolver
import org.springframework.web.servlet.resource.ResourceResolverChain

@Configuration
class SinglePageAppConfig : WebMvcConfigurer {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .resourceChain(false)
            .addResolver(PushStateResourceResolver())
    }

    private class PushStateResourceResolver : ResourceResolver {
        private val index: Resource = ClassPathResource("static/index.html")
        private val handledExtensions = listOf(
            "html", "js", "map", "json", "csv", "css",
            "png", "svg", "eot", "ttf", "woff",
            "appcache", "jpg", "jpeg", "gif", "ico"
        )
        private val ignoredPaths = listOf("api")

        override fun resolveResource(
            request: HttpServletRequest?,
            requestPath: String,
            locations: MutableList<out Resource>,
            chain: ResourceResolverChain
        ): Resource? {
            return resolve(requestPath, locations)
        }

        override fun resolveUrlPath(
            resourcePath: String,
            locations: MutableList<out Resource>,
            chain: ResourceResolverChain
        ): String? {
            val resolved = resolve(resourcePath, locations) ?: return null
            return try {
                resolved.url.toString()
            } catch (e: Exception) {
                LoggerFactory.getLogger(this::class.java)
                    .info("Could not get URL from resource", e)
                resolved.filename
            }
        }

        private fun resolve(requestPath: String, locations: List<Resource>): Resource? {
            if (isIgnored(requestPath)) {
                // API 등 백엔드 라우팅으로 넘기기 위해 null 반환
                return null
            }
            if (isHandled(requestPath)) {
                return locations.asSequence()
                    .mapNotNull { createRelative(it, requestPath) }
                    .firstOrNull { it.exists() }
            }
            // SPA 라우팅: 정적/백엔드가 아니면 index.html
            return index
        }

        private fun createRelative(resource: Resource, relativePath: String): Resource? {
            return try {
                resource.createRelative(relativePath)
            } catch (e: Exception) {
                LoggerFactory.getLogger(this::class.java)
                    .info("Could not create resource from relative path", e)
                null
            }
        }

        private fun isIgnored(path: String): Boolean {
            return ignoredPaths.any { path.startsWith(it) }
        }

        private fun isHandled(path: String): Boolean {
            val ext = StringUtils.getFilenameExtension(path) ?: return false
            return handledExtensions.any { it == ext }
        }
    }
}
