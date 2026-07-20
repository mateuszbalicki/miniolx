package com.matb.miniolx.advertisement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;
import java.util.UUID;

@Service
public class AdvertisementImageService {

    private final S3Presigner s3Presigner;
    private final String bucketName;

    public AdvertisementImageService(S3Presigner s3Presigner,
                                     @Value("${aws.s3.bucket-name}") String bucketName) {
        this.s3Presigner = s3Presigner;
        this.bucketName = bucketName;
    }

    public PresignedUrlResponse generateUploadUrl(UUID advertisementId, String fileExtension) {
        UUID imageId = UUID.randomUUID();

        String s3Key = "images/ads/" + advertisementId + "/" + imageId + "." + fileExtension;

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(s3Key)
                .contentType("image/" + fileExtension)
                .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(15))
                .putObjectRequest(objectRequest)
                .build();

        PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);

        return new PresignedUrlResponse(imageId, presignedRequest.url().toString(), s3Key);
    }
}