package com.example.api.domain.user.business;

import com.example.api.common.annotation.Business;
import com.example.api.domain.user.controller.model.UserLoginRequest;
import com.example.api.domain.user.controller.model.UserRegisterRequest;
import com.example.api.domain.user.controller.model.UserResponse;
import com.example.api.domain.user.converter.UserConverter;
import com.example.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class UserBusiness {

    /*
    * 비즈니스는 여러개의 서비스를 가져와서 로직을 처리하는 과정을
    * 담당한다.
    * */
    private final UserService userService;
    private final UserConverter userConverter;

    /**
     * 사용자에 대한 가입처리 로직
     * 1. request -> entity
     * 2. entity -> save
     * 3. save Entity -> response
     * 4. response return
     */
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);
        return response;

        /* 위 아래 둘은 동일한 코드 */
        /* return Optional.ofNullable(request)
            .map(userConverter::toEntity)
            .map(userService::register)
            .map(userConverter::toResponse)
            .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "request null"));*/
    }

    /**
     * 1. email, password 를 가지고 사용자 체크
     * 2. user entity 로그인 확인
     * 3. token 생성
     * 4. token response
     */
    public UserResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request.getEmail(), request.getPassword());
        // TODO 토큰 생성
        return userConverter.toResponse(userEntity);
    }
}
