package com.matb.miniolx.advertisement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    private final AdvertisementService advertisementService;
    private final AdvertisementImageService advertisementImageService;

    public AdvertisementController(AdvertisementService advertisementService, AdvertisementImageService advertisementImageService) {
        this.advertisementService = advertisementService;
        this.advertisementImageService = advertisementImageService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementResponse> createAdvertisement(@RequestBody AdvertisementCreateRequest request) {
        AdvertisementResponse response = advertisementService.createAdvertisement(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{advertisementId}/images/upload-url")
    public ResponseEntity<PresignedUrlResponse> uploadImage(@PathVariable UUID advertisementId) {
        PresignedUrlResponse response = advertisementImageService.generateUploadUrl(advertisementId, "jpg");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
