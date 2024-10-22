package com.example.api.domain.user.controller;

import com.example.api.common.api.Api;
import com.example.api.domain.token.controller.model.TokenResponse;
import com.example.api.domain.user.business.UserBusiness;
import com.example.api.domain.user.controller.model.UserLoginRequest;
import com.example.api.domain.user.controller.model.UserRegisterRequest;
import com.example.api.domain.user.controller.model.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    /*
    * open-api 와 그냥 api 의 차이는 web 의 config 에서 설정한
    * 인증작업을 진행하느냐 진행하지 않느냐에 대한 차이이다.
    * open-api 는 인터셉터에서 인증작업을 거치지 않는다.
    * */

    private final UserBusiness userBusiness;

    // 사용자 가입 요청
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ){
        var response = userBusiness.register(request.getBody());
        return Api.OK(response);
    }

    // 로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
            @Valid
            @RequestBody Api<UserLoginRequest> request
    ){
        var response = userBusiness.login(request.getBody());
        return Api.OK(response);
    }
}
