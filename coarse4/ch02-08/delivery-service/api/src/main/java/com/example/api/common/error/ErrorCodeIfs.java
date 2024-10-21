package com.example.api.common.error;

public interface ErrorCodeIfs {

    /* 에러코드가 수십, 수백개로 많아지는 경우,
       헷갈리거나 에러가 발생할 수 있으므로 인터페이스로 만들고 확장가능 하도록 함.
       에러코드에 대한 커스터마이징이 가능함.

       클라이언트에 에러 메세지를 보낼 때의 공통된 내용에 대한 커스터마이징
     */

    Integer getHttpStatusCode();

    Integer getErrorCode();

    String getDescription();
}
