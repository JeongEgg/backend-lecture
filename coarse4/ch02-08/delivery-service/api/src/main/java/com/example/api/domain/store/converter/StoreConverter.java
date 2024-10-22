package com.example.api.domain.store.converter;

import com.example.api.common.annotation.Converter;
import com.example.api.common.error.ErrorCode;
import com.example.api.common.exception.ApiException;
import com.example.api.domain.store.controller.model.StoreRegisterRequest;
import com.example.api.domain.store.controller.model.StoreResponse;
import com.example.db.store.StoreEntity;

import java.util.Optional;

@Converter
public class StoreConverter {

    // StoreRegisterRequest -> StoreEntity
    public StoreEntity toEntity(
            StoreRegisterRequest request
    ){
        return Optional.ofNullable(request)
                .map(it ->{
                    return StoreEntity.builder()
                            .name(request.getName())
                            .address(request.getAddress())
                            .category(request.getStoreCategory())
                            .minimumAmount(request.getMinimumAmount())
                            .minimumDeliveryAmount(request.getMinimumDeliveryAmount())
                            .thumbnailUrl(request.getThumbnailUrl())
                            .phoneNumber(request.getPhoneNumber())
                            .build()
                            ;
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    // StoreEntity -> StoreResponse
    public StoreResponse toResponse(
            StoreEntity entity
    ){
        return Optional.ofNullable(entity)
                .map(it ->{
                    return StoreResponse.builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .status(entity.getStatus())
                            .category(entity.getCategory())
                            .address(entity.getAddress())
                            .minimumAmount(entity.getMinimumAmount())
                            .minimumDeliveryAmount(entity.getMinimumDeliveryAmount())
                            .thumbnailUrl(entity.getThumbnailUrl())
                            .phoneNumber(entity.getPhoneNumber())
                            .star(entity.getStar())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
