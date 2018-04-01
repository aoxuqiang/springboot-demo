package com.miqi.springbootdemo.exception;

import com.miqi.springbootdemo.dto.ApiRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class CommonExceptionInterceptor {
    private Logger log = LoggerFactory.getLogger(CommonExceptionInterceptor.class);
    @ExceptionHandler(Exception.class)
    public ApiRet handleException(HttpServletRequest req, Exception e){
        log.error("请求失败");
        ApiRet ret = new ApiRet();
        ret.setRet(1001);
        ret.setMsg("请求出错!");
        return ret;
    }
}
