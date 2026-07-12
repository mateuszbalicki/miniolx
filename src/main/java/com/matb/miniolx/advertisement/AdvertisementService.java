package com.matb.miniolx.advertisement;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdvertisementService {
    final AdvertisementRepository advertisementRepository;

    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public AdvertisementResponse createAdvertisement(AdvertisementCreateRequest request) {
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(request.title());
        advertisement.setDescription(request.description());
        advertisement.setPrice(request.price());
        advertisement.setStatus(AdvertisementStatus.ACTIVE);
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        return new AdvertisementResponse(savedAdvertisement.getAdvertisementId(), savedAdvertisement.getTitle(), savedAdvertisement.getDescription(), savedAdvertisement.getPrice(), savedAdvertisement.getStatus());

    }
}
