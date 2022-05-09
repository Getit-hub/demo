package com.sww.controller;

import com.sww.exception.BusinessException;
import com.sww.exception.SystemException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler({BusinessException.class})
    public  Result doBusinessException(SystemException exception){
        return  new Result(exception.getCode(),null, exception.getMessage());
    }

    @ExceptionHandler({SystemException.class})
    public  Result doSystemException(SystemException exception){
        //记录日志
        //发送邮件给开发人员
        //发送短信给运维人员
        return  new Result(exception.getCode(),null, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public  Result doException(Exception exception){
        //记录日志
        //发送邮件给开发人员
        //发送短信给运维人员
        return  new Result(Code.SYSTEM_UNKNOWN_ERROR,null, "系统异常 请联系管理员");
    }
}
