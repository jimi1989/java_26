package com.kaishengit.erp.controller.exceptionHandler;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/7/24
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IOException.class)
    public String ioExceptionHandler() {
        return "error/500";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException() {
        return "error/401";
    }

}
