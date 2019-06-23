package com.ruisdata.quiz.controller;

import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.service.CityListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("考核第一题接口")
@RequestMapping("/city")
public class MyController {

    @Autowired
    CityListService cityListService;

    @RequestMapping("/test")
    @ApiOperation(value = "测试接口", httpMethod = "POST")
    public BaseResponse test() {
        BaseResponse baseResponse = new BaseResponse(200,"成功", 12346);
        return baseResponse;
    }

    @RequestMapping("/list")
    @ApiOperation(value = "输入城市，获取城市排序列表接口", httpMethod = "GET")
    public BaseResponse getCities(@RequestParam List<String> cities) throws BadHanyuPinyinOutputFormatCombination {
        BaseResponse cityList = cityListService.getCityList(cities);
        return cityList;

    }
}
