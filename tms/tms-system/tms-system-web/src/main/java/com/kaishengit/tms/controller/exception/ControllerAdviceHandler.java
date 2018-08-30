package com.kaishengit.tms.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(org.apache.shiro.authz.UnauthorizedException.class)
    public String unauthorizedHandler() {
        return "error/401";
    }
}
