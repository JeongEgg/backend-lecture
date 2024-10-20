package com.example.api.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /*
    *  config 패키지에서 직접 커스터마이징하여 설정한 objectmapper 의 스프링 빈을
    *  찾아서 스웨거 설정의 매개변수에 주입해준다.
    * */
    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper){
        return new ModelResolver(objectMapper);
    }
}