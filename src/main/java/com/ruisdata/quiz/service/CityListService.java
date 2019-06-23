package com.ruisdata.quiz.service;

import com.ruisdata.quiz.VO.response.BaseResponse;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.List;

public interface CityListService {

    /**
     *  输出城市中文名，按城市拼音首字母分组，组之间按字母排序，组内按城市名id排序
     * @param cities
     * @return
     */
    BaseResponse getCityList(List<String> cities) throws BadHanyuPinyinOutputFormatCombination;
}
