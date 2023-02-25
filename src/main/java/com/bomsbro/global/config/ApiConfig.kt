package com.bomsbro.global.config

import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class ApiConfig(
    @Value("\${minio.url}") private val url: String,
    @Value("\${minio.id}") private val id: String,
    @Value("\${minio.password}") private val password: String
) {
    @Bean
    open fun minioClient():MinioClient = MinioClient.builder()
        .endpoint(url)
        .credentials(id, password)
        .build();
}