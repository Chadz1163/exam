package com.ruisdata.quiz.test;

import com.ruisdata.quiz.PO.ArgueOpinionPO;
import com.ruisdata.quiz.PO.ArguePO;
import com.ruisdata.quiz.PO.UserInfoPO;
import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.dao.exam2.ArgueMapper;
import com.ruisdata.quiz.service.ArgueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArgueTest {

    @Autowired
    ArgueMapper argueMapper;

    @Test
    public void getArgueIdWithOpinionCountTest() {
        Integer argueIdWithOpinionCount = argueMapper.getArgueIdWithOpinionCount(1L);
        System.out.println(argueIdWithOpinionCount);
    }

    @Test
    public void getArgueList() {
        List<ArguePO> argueList = argueMapper.getArgueList();
        for (ArguePO po : argueList) {
            System.out.println(po.getId());
        }


    }

    @Test
    public void getArgueOpinionByLikeCount() {
        ArgueOpinionPO argueOpinionByLikeCount = argueMapper.getArgueOpinionByLikeCount(1L);
        System.out.println(argueOpinionByLikeCount.toString());
    }

    @Test
    public void getUserInfoById() {
        UserInfoPO userInfoById = argueMapper.getUserInfoById(15L);
        System.out.println(userInfoById.toString());
    }

    @Test
    public void getArgueTitleByIdMapper() {
        String argueTitleById = argueMapper.getArgueTitleById(1L);
        System.out.println(argueTitleById);
    }

    @Autowired
    ArgueService argueService;
    @Test
    public void argueServiceTest() {
        BaseResponse argueList = argueService.getArgueList();
        System.out.println(argueList);
    }
}
