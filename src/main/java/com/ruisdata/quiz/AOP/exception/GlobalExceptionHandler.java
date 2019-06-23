package com.ruisdata.quiz.AOP.exception;

import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.enums.ResponseEnums;
import com.ruisdata.quiz.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 校验请求参数（基本类型）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse constraintViolationExceptionHandler(ConstraintViolationException ex) {
        return new BaseResponse(ResponseEnums.FAIL.getStatus(), ResponseEnums.FAIL.getMsg(), null);
    }
    
    /**
     * service层异常
     */
    @ExceptionHandler(ServiceException.class)
    public BaseResponse serviceExceptionHandler(ServiceException ex) {
        return new BaseResponse(ResponseEnums.FAIL.getStatus(), ex.getMessage(), null);
    }
    
}
