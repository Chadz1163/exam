package com.ruisdata.quiz.service.Impl;

import com.ruisdata.quiz.PO.City;
import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.VO.response.CityVO;
import com.ruisdata.quiz.dao.exam1.CityMapper;
import com.ruisdata.quiz.service.CityListService;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityListServiceImpl implements CityListService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public BaseResponse getCityList(List<String> list) throws BadHanyuPinyinOutputFormatCombination {

        // 创建一个格式化输出对象
        HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();
        // 设置好格式
        outputF.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputF.setCaseType(HanyuPinyinCaseType.UPPERCASE);

        // 根据输入的城市名查数据库，得到List
        List<City> cities = new ArrayList<>();

        for (String name : list) {
            cities.add(cityMapper.getCities(name));
        }
        // TreeMap默认排序就是 A - Z
        Map<String, Object> map = new TreeMap();
        // 获取首字母，并放入Map中
        /*List<Character> chars = new ArrayList<>();
        for (String test : list) {
            chars.add(test.charAt(0));
        }
        List<String> firstLetter = new ArrayList<>();

        for (int i = 0; i < chars.size(); i++) {
            char ch = chars.get(i);
            String[] str = PinyinHelper.toHanyuPinyinStringArray(ch, outputF);
            firstLetter.add(String.valueOf(str[0].charAt(0)));
        }
        //结果有多个，因为多音,但是我们选择的音调类型是WITHOUT_TONE,所以拼音数组后面也没有对应音调数字
        for (int k = 0; k < firstLetter.size(); k++) {
            map.put(firstLetter.get(k), new ArrayList<City>());
        }*/

        //-----------------------------------------
        // 遍历出输入城市的首字母，分组排序，加入map中
        for (int j = 0; j < cities.size(); j++) {
            List<City> cityList = new ArrayList<>();
            // 获取第一个城市的信息和首字母
            City city1 = cities.get(j);
            String cityName1 = city1.getCityName();
            String[] strings1 = PinyinHelper.toHanyuPinyinStringArray(cityName1.charAt(0), outputF);

            char c1 = strings1[0].charAt(0);
            cityList.add(city1);

            for (int i = 0; i < cities.size(); i++) {
                // 获取第二个城市的信息和首字母
                City city2 = cities.get(i);
                String cityName2 = city2.getCityName();
                String[] strings2 = PinyinHelper.toHanyuPinyinStringArray(cityName2.charAt(0), outputF);
                char c2 = strings2[0].charAt(0);
                // 比较两个城市的首字母是否相同
                if (c1 == c2) {
                    // 判断两个城市是否是同一个城市
                    if (cityName1.equals(cityName2)) {
                        break;
                    }
                    cityList.add(city2);
                }
            }
            // 在City类中实现了Comparable<T>接口
            Collections.sort(cityList);
            map.put(String.valueOf(c1), cityList);
        }
        List<CityVO> listVO = new ArrayList<>();
        for (String str: map.keySet()) {
            CityVO cityVO = new CityVO();
            cityVO.setLetter(str);
            cityVO.setCities(map.get(str));
            listVO.add(cityVO);
        }
        BaseResponse baseResponse = new BaseResponse(200, "成功", listVO);


        return baseResponse;
    }
}
