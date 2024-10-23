package com.example.api.domain.userorder.converter;

import com.example.api.common.annotation.Converter;
import com.example.api.domain.user.model.User;
import com.example.api.domain.userorder.controller.model.UserOrderResponse;
import com.example.db.storemenu.StoreMenuEntity;
import com.example.db.userorder.UserOrderEntity;

import java.math.BigDecimal;
import java.util.List;

@Converter
public class UserOrderConverter {

    public UserOrderEntity toEntity(
            User user,
            List<StoreMenuEntity> storeMenuEntityList
    ){
        var totalAmount = storeMenuEntityList.stream()
                .map(it -> it.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return UserOrderEntity.builder()
                .userId(user.getId())
                .amount(totalAmount)
                .build()
                ;
    }

    public UserOrderResponse toResponse(
            UserOrderEntity userOrderEntity
    ){
        return UserOrderResponse.builder()
                .id(userOrderEntity.getId())
                .status(userOrderEntity.getStatus())
                .amount(userOrderEntity.getAmount())
                .orderedAt(userOrderEntity.getOrderedAt())
                .acceptedAt(userOrderEntity.getAcceptedAt())
                .cookingStartedAt(userOrderEntity.getCookingStartedAt())
                .deliveryStartedAt(userOrderEntity.getDeliveryStartedAt())
                .receivedAt(userOrderEntity.getReceivedAt())
                .build()
                ;
    }
}
