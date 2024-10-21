package com.example.api.config.web;

import com.example.api.interceptor.AuthorizationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    * 인터셉터를 등록시키기 위한 config 설정.
    * */
    private final AuthorizationInterceptor authorizationInterceptor;

    /*
    * 검증하지 않는 요청 경로 설정. 아래의 경로들은 인증과정으로부터 제외시킨다.
    * 아래의 설정된 경로 이외에는 검증작업을 진행한다.
    * */
    private List<String> OPEN_API = List.of(
            "/open-api/**"
    );

    private List<String> DEFAULT_EXCLUDE = List.of(
            "/",
            "favicon.ico",
            "/error"
    );

    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .excludePathPatterns(OPEN_API)
                .excludePathPatterns(DEFAULT_EXCLUDE)
                .excludePathPatterns(SWAGGER)
        ;

    }
}
