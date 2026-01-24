package com.tailorapp.storage.service;

import com.tailorapp.common.enums.UploadModule;
import com.tailorapp.common.util.FileNameUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3FileStorageServiceImpl implements FileStorageService {

    @Value("${aws.s3.bucket-name}")
    private String bucket;

    @Value("${aws.s3.base-url}")
    private String baseUrl;

    private final S3Client s3Client;

    public S3FileStorageServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String uploadImage(
            MultipartFile file,
            UploadModule module,
            Long referenceId) {

        String fileName = FileNameUtil.generateFileName(file.getOriginalFilename());

        String key = module.getFolder()
                + "/" + referenceId
                + "/" + fileName;

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(file.getContentType())
                .build();

        try {
            s3Client.putObject(
                    request,
                    RequestBody.fromBytes(file.getBytes())
            );
        } catch (IOException e) {
            throw new RuntimeException("S3 upload failed", e);
        }

        return baseUrl + "/" + key;
    }
}
