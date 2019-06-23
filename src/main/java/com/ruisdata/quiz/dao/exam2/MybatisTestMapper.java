package com.ruisdata.quiz.dao.exam2;

import com.ruisdata.quiz.PO.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MybatisTestMapper {

    /**
     * 获取城市列表
     * @return
     */
    List<City> getCities();
}