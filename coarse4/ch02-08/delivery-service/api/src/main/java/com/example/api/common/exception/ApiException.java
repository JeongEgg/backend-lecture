package com.example.api.common.exception;

import com.example.api.common.error.ErrorCodeIfs;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs {

    /*
    * 어플리케이션 실행중(RuntimeException)에 발생하는 에러를 커스터마이징 하여 사용하도록 함.
    * */

    private final ErrorCodeIfs errorCodeIfs;
    private final String errorDescription;

    public ApiException(ErrorCodeIfs errorCodeIfs){
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, String errorDescription){
        super(errorDescription);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorDescription;
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx){
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx, String errorDescription){
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorDescription;
    }
}