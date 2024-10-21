package com.example.api.exceptionhandler;

import com.example.api.common.api.Api;
import com.example.api.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)   // 최우선처리
public class ApiExceptionHandler {

    /*
    * 에러가 발생하는 경우의 응답을 위의 공통 api 응답에서 커스터마이징 한 것을 가져와서 사용함.
    * */
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api<Object>> apiException(
            ApiException apiException
    ){
        log.error("", apiException);

        var errorCode = apiException.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(
                        Api.ERROR(errorCode, apiException.getErrorDescription())
                );

    }
}
