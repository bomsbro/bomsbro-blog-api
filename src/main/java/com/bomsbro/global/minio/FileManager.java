package com.bomsbro.global.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.apache.commons.compress.utils.IOUtils;

import java.io.InputStream;

// 자체적으로 빈등록하고
// 생성되지않게

public class FileManager {
    private final MinioClient minioClient;
    private int partSize = 512 * 1024; // Set part size to 2 MB

    public FileManager(String url, String id, String password){
        minioClient = MinioClient.builder()
                .endpoint(url)
                .credentials(id, password)
                .build();
    }

    public boolean putObject(String bucketName, String objectName, InputStream inputStream) {
        boolean result = false;

        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (found) {
                minioClient.putObject(
                        PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                        inputStream, size, this.partSize)
                        .build()
                );
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }

    /*
    public byte[] getObject(String bucket, String filepath) {
        byte[] result = null;
        try {
            boolean found = minioClient.bucketExists(bucket);
            if (found) {
                result = IOUtils.toByteArray(minioClient.getObject(bucket, filepath));
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }

    public boolean removeObject(String bucket, String filepath) {
        boolean result = false;
        try {
            boolean found = minioClient.bucketExists(bucket);
            if (found) {
                minioClient.removeObject(bucket, filepath);
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }
}
