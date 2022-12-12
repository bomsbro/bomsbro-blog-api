package com.bomsbro.global.minio;

public class TestMinIO {

    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager();
            fileManager.putObject("sample","testfile.zip", "C:/testfile/test.jpg");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
