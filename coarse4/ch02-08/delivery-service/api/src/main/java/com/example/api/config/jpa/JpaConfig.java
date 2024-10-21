package com.example.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.example.db")
@EnableJpaRepositories(basePackages = "com.example.db")
public class JpaConfig {
    /* db 프로젝트의 POJO 클래스를 빈으로 등록하여 api 프로젝트에서
       사용가능하도록 하기 위한 빈 등록의 config 설정
     */
}
