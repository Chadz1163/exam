package com.ruisdata.quiz.test;

import com.ruisdata.quiz.PO.City;
import com.ruisdata.quiz.dao.exam2.MybatisTestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisTest {

    @Autowired
    private MybatisTestMapper mybatisTestMapper;

    @Test
    public void setMybatisTestMapper() {
        List<City> cities = mybatisTestMapper.getCities();
        System.out.println(cities);
    }
}
