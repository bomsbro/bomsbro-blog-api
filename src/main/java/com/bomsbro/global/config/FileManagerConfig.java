package com.bomsbro.global.config;

import com.bomsbro.global.minio.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;


@Configuration
public class FileManagerConfig {
    @Bean
    public FileManager fileManager() {
        return new FileManager("https://s3.bomsbro.com", "bomsbro-blog-api", "a1a2a3a4", "bomsbro-blog-files");
    }
}
