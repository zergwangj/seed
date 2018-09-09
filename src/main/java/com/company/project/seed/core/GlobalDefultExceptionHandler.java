package com.company.project.seed.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalDefultExceptionHandler {
    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        Result result = new Result();
        if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
            log.info(e.getMessage());
        } else if (e instanceof NoHandlerFoundException) {
            result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
        } else if (e instanceof ServletException) {
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
        } else {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            String message = e.getMessage();
            log.error(message, e);
        }

        return result;
    }

}
