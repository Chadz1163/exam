package com.ruisdata.quiz.enums;

import lombok.Getter;

@Getter
public enum ResponseEnums {
    OK(200, "成功"),
    FAIL(201, "失败"),
    INVALIDREQUEST(400, "请求参数异常"),
    UNAUTHORIZED(401, "用户没有权限"),
    INTENAL_SERVIER_ERROR(500, "内部服务错误");
    private Integer status;
    private String msg;

    ResponseEnums(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
