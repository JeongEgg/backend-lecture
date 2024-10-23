package com.example.api.domain.userordermenu.service;

import com.example.api.common.error.ErrorCode;
import com.example.api.common.exception.ApiException;
import com.example.db.userordermenu.UserOrderMenuEntity;
import com.example.db.userordermenu.UserOrderMenuRepository;
import com.example.db.userordermenu.enums.UserOrderMenuStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserOrderMenuService {

    private final UserOrderMenuRepository userOrderMenuRepository;

    public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId){
        // null 이면 값이 나오지 않을 것이므로, null 체크를 할 필요가 없다.
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }

    public UserOrderMenuEntity order(
            UserOrderMenuEntity userOrderMenuEntity
    ){
        return Optional.ofNullable(userOrderMenuEntity)
                .map(it ->{
                    it.setStatus(UserOrderMenuStatus.REGISTERED);
                    return userOrderMenuRepository.save(it);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

}
