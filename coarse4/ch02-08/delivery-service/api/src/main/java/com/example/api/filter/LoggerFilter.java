package com.example.api.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // request, response 의 형변환
        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        log.info("INIT URI : {}", req.getRequestURI());
        // doFilter 이전에 req, res를 사용하려면 캐싱을 해야 함. 여기서는 적용하지 않고 doFilter 이후에 로그를 찍는다.
        chain.doFilter(req, res);

        // request 정보
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerKey ->{
            var headerValue = req.getHeader(headerKey);

            // authorization-token : ??? , user-agent : ???
            headerValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        var requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();

        log.info(">>>>> uri : {} , method : {} , header : {} , body : {}", uri, method, headerValues, requestBody);


        // response 정보
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerKey ->{
            var headerValue = res.getHeader(headerKey);

            responseHeaderValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        var responseBody = new String(res.getContentAsByteArray());

        log.info("<<<<< uri : {} , method : {} , header : {} , body : {}", uri, method, responseHeaderValues, responseBody);

        // 이 부분을 쓰지 않으면 response body가 비워져서 응답됨.
        res.copyBodyToResponse();
    }
}
