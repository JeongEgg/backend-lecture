package com.example.storeadmin.domain.user.controller;

import com.example.storeadmin.domain.authorization.model.UserSession;
import com.example.storeadmin.domain.user.controller.model.StoreUserResponse;
import com.example.storeadmin.domain.user.converter.StoreUserConverter;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store-user")
public class StoreUserApiController {

    private final StoreUserConverter storeUserConverter;

    @GetMapping("/me")
    public StoreUserResponse me(
            @Parameter(hidden = true)
            @AuthenticationPrincipal UserSession userSession
    ){
        return storeUserConverter.toResponse(userSession);
    }
}
