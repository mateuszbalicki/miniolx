package com.matb.miniolx.advertisement;

import java.math.BigDecimal;
import java.util.UUID;

public record AdvertisementResponse(UUID advertisementId, String title, String description, BigDecimal price, AdvertisementStatus status) {
}
