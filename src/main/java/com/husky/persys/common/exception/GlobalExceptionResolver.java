package com.husky.persys.common.exception;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionResolver {
    @ExceptionHandler(value=ShiroException.class)
    @ResponseBody
    public ErrorInfo shiroExceptionResolve(HttpServletRequest request,ShiroException e){
        ErrorInfo info = new ErrorInfo();
        if(e instanceof AuthorizationException){
            info.setCode(ErrorInfo.ACCESS_DENIED);
            info.setMessage(e.getMessage());
            info.setUrl(request.getRequestURI().toString());
        }
        return info;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorInfo customExceptionResolve(HttpServletRequest request,CustomException e){
        return null;
    }
}
