package com.ruisdata.quiz.dao.exam1;

import com.ruisdata.quiz.PO.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface CityMapper {

    /**
     * 获取城市信息
     */
    City getCities(@Param("cityName") String cityName);
}
