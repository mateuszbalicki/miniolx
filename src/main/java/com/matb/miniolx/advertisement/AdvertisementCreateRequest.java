package com.matb.miniolx.advertisement;

import com.matb.miniolx.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AdvertisementCreateRequest(UUID authorId, String title, String description, BigDecimal price) {
}
