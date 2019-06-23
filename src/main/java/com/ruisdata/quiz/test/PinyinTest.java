package com.ruisdata.quiz.test;

import com.ruisdata.quiz.PO.City;
import com.ruisdata.quiz.dao.exam2.MybatisTestMapper;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PinyinTest {

    @Autowired
    private MybatisTestMapper mybatisTestMapper;

    @Test
    public void pinyinTest() throws BadHanyuPinyinOutputFormatCombination {
        //1.创建一个格式化输出对象
        HanyuPinyinOutputFormat outputF = new HanyuPinyinOutputFormat();
        //2.设置好格式
        outputF.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputF.setCaseType(HanyuPinyinCaseType.UPPERCASE);

        List<String> list = new ArrayList<>();
        list.add("上海");
        list.add("北京");
        list.add("包头");
        list.add("南京");
        list.add("深圳");


        List<City> cities = mybatisTestMapper.getCities();
        System.out.println(cities);
        // TreeMap默认排序就是 A - Z
        Map<String, Object> map = new TreeMap();
        // 获取首字母，并放入Map中
        List<Character> chars = new ArrayList<>();
        for (String test : list) {
            chars.add(test.charAt(0));
        }
        System.out.println("chars:" + chars);

        List<String> firstLetter = new ArrayList<>();

        for (int i = 0; i < chars.size(); i++) {
            char ch = chars.get(i);
            String[] str = PinyinHelper.toHanyuPinyinStringArray(ch, outputF);
            firstLetter.add(String.valueOf(str[0].charAt(0)));
            //3.打印输出
            System.out.println(Arrays.toString(str));
        }
        System.out.println(firstLetter);
        //结果有多个，因为多音,但是我们选择的音调类型是WITHOUT_TONE,所以拼音数组后面也没有对应音调数字

        for (int k = 0; k < firstLetter.size(); k++) {
            map.put(firstLetter.get(k), new ArrayList<City>());
        }
        System.out.println(map);

        //-----------------------------------------
        // 遍历出所有城市的首字母，加入map中
        for (int j = 0; j < cities.size(); j++) {
            List<City> cityList = new ArrayList<>();
            City city1 = cities.get(j);
            String cityName1 = city1.getCityName();
            String[] strings1 = PinyinHelper.toHanyuPinyinStringArray(cityName1.charAt(0), outputF);

            char c1 = strings1[0].charAt(0);
            cityList.add(city1);

            for (int i = 0; i < cities.size(); i++) {

                City city2 = cities.get(i);
                String cityName2 = city2.getCityName();
                String[] strings2 = PinyinHelper.toHanyuPinyinStringArray(cityName2.charAt(0), outputF);

                char c2 = strings2[0].charAt(0);
                if (c1 == c2) {
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
        System.out.println("map:" + map);
    }


    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("上海");
        list.add("北京");
        list.add("包头");
        list.add("广州");
        list.add("深圳");


        Collections.sort(list);
        System.out.println(list);
    }
}
