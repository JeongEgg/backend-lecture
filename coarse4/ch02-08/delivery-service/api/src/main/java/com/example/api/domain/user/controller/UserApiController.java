package com.example.api.domain.user.controller;

import com.example.api.common.annotation.UserSession;
import com.example.api.common.api.Api;
import com.example.api.domain.user.business.UserBusiness;
import com.example.api.domain.user.controller.model.UserResponse;
import com.example.api.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    /*
    * 차단된 api. 로그인해야만 사용 가능한 api
    * */

    private final UserBusiness userBusiness;

    @GetMapping("/me")
    public Api<UserResponse> me(
            @UserSession User user
    ){
        var response = userBusiness.me(user);
        return Api.OK(response);
    }
}
