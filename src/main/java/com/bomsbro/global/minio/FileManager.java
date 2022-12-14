package com.bomsbro.global.minio;


// 자체적으로 빈등록하고
// 생성되지않게

import io.minio.*;
import io.minio.http.Method;
// import org.apache.commons.compress.utils.IOUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FileManager {
    private final MinioClient minioClient;
    private int partSize = 512 * 1024; // Set part size to 2 MB
    private String bucketName;

    public FileManager(String url, String id, String password, String bucketName){
        minioClient = MinioClient.builder()
                .endpoint(url)
                .credentials(id, password)
                .build();
        this.bucketName=bucketName;
    }

    public String getPresignedObjectUrl(String objectName) {
        String url = "";
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(this.bucketName).build());
            if (found) {
                Map<String, String> reqParams = new HashMap<String, String>();

                url = minioClient.getPresignedObjectUrl(
                                GetPresignedObjectUrlArgs.builder()
                                        .method(Method.GET)
                                        .bucket(this.bucketName)
                                        .object(objectName)
                                        .expiry(2, TimeUnit.HOURS)
                                        .build());
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return url;
    }

    public boolean putObject( String objectName, InputStream inputStream) {
        boolean result = false;
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(this.bucketName).build());
            if (found) {
                minioClient.putObject(
                        PutObjectArgs.builder().bucket(this.bucketName).object(objectName).stream(
                        inputStream, -1, this.partSize)
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
    public byte[] getObject( String objectName) {
        byte[] result = null;
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(this.bucketName).build());
            if (found) {
                result = IOUtils.toByteArray(minioClient.getObject(GetObjectArgs.builder().bucket(this.bucketName).object(objectName).build()));
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }

    public boolean removeObject( String objectName) {
        boolean result = false;
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(this.bucketName).build());
            if (found) {
                minioClient.removeObject(RemoveObjectArgs.builder().bucket(this.bucketName).object(objectName).build());
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }
    */
}
