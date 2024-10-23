package com.example.storeadmin.domain.user.business;

import com.example.db.store.StoreRepository;
import com.example.db.store.enums.StoreStatus;
import com.example.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import com.example.storeadmin.domain.user.controller.model.StoreUserResponse;
import com.example.storeadmin.domain.user.converter.StoreUserConverter;
import com.example.storeadmin.domain.user.service.StoreUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreUserBusiness {

    private final StoreUserConverter storeUserConverter;
    private final StoreUserService storeUserService;

    private final StoreRepository storeRepository;  // TODO SERVICE 로 변경하기


    public StoreUserResponse register(
            StoreUserRegisterRequest request
    ){
        var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTERED);

        var entity = storeUserConverter.toEntity(request, storeEntity.get());

        var newEntity = storeUserService.register(entity);

        var response = storeUserConverter.toResponse(newEntity, storeEntity.get());

        return response;
    }
}