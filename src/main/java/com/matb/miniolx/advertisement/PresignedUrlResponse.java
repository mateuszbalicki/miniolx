package com.matb.miniolx.advertisement;

import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.UUID;

public record PresignedUrlResponse(UUID imageId, String uploadUrl, String s3Key) {
}
