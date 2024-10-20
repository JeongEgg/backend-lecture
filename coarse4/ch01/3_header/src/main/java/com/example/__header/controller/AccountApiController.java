package com.example.__header.controller;

import com.example.__header.model.LoginRequest;
import com.example.__header.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse,
            HttpSession httpSession
    ){
        return userService.login(loginRequest, httpServletResponse);
    }
}