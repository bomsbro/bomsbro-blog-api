package com.bomsbro.global.config;

import com.bomsbro.global.minio.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;


@Configuration
public class FileManagerConfig {
    @Bean
    public FileManager fileManager( String objectName, InputStream inputStream) {
        return new FileManager("bomsbro-blog-files", objectName, inputStream);
    }
}
