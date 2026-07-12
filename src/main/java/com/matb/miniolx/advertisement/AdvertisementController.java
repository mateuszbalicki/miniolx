package com.matb.miniolx.advertisement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementResponse> createAdvertisement(@RequestBody AdvertisementCreateRequest request) {
        AdvertisementResponse response = advertisementService.createAdvertisement(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
