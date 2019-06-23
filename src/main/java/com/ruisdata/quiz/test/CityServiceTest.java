package com.ruisdata.quiz.test;

import com.ruisdata.quiz.PO.City;
import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.dao.exam1.CityMapper;
import com.ruisdata.quiz.service.CityListService;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CityServiceTest {
    @Autowired
    CityMapper cityMapper;

    @Autowired
    CityListService cityListService;
    @Test
    public void getCitiesMapperTest() {
        City city = cityMapper.getCities("上海");
        System.out.println(city.toString());
    }
    @Test
    public void CityServiceTest() throws BadHanyuPinyinOutputFormatCombination {
        List<String> list = new ArrayList<>();
        list.add("上海");
        list.add("北京");
        list.add("包头");

        BaseResponse cityList = cityListService.getCityList(list);
        System.out.println(cityList.toString());
    }
}
