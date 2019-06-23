package com.ruisdata.quiz.controller;

import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.service.ArgueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("考核第二题接口")
@RequestMapping("/app-firstpage-service/api/v1/recommend")
public class ArgueController {

    @Autowired
    ArgueService argueService;

    @RequestMapping("/argue")
    @ApiOperation(value = "获取热门话题列表和响应的热门观点", httpMethod = "GET")
    public BaseResponse argue() {
        BaseResponse argueList = argueService.getArgueList();

        return argueList;
    }
}
