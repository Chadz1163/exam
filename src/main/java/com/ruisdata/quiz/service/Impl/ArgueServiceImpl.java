package com.ruisdata.quiz.service.Impl;

import com.ruisdata.quiz.PO.ArgueOpinionPO;
import com.ruisdata.quiz.PO.ArguePO;
import com.ruisdata.quiz.PO.UserInfoPO;
import com.ruisdata.quiz.VO.response.ArgueResponseVO;
import com.ruisdata.quiz.VO.response.BaseResponse;
import com.ruisdata.quiz.VO.response.RecommendArgueOpinionResponseVO;
import com.ruisdata.quiz.dao.exam2.ArgueMapper;
import com.ruisdata.quiz.service.ArgueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArgueServiceImpl implements ArgueService {

    @Autowired
    ArgueMapper argueMapper;

    @Override
    public BaseResponse getArgueList() {

        // 获取所有的话题
        List<ArguePO> argueList = argueMapper.getArgueList();

        //List<Integer> argueIdList = new ArrayList();
        Map argueMap = new TreeMap();
        // 获取每个话题的观点数，将话题id排序
        for (ArguePO po : argueList) {
            argueMap.put(po.getId(), argueMapper.getArgueIdWithOpinionCount(po.getId()));
        }
        // 将map.entrySet()转换成list
        List<Map.Entry<Long, Integer>> list = new ArrayList<Map.Entry<Long, Integer>>(argueMap.entrySet());
        // 通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<ArgueResponseVO> responseVOS = new ArrayList<>();

        for (Map.Entry<Long, Integer> mapping : list) {

            ArgueResponseVO argueResponseVO = new ArgueResponseVO();
            // 获取该话题的最高赞的观点，和发表该观点的用户信息, 根据话题id获取短体标题
            ArgueOpinionPO argueOpinion = argueMapper.getArgueOpinionByLikeCount(mapping.getKey());
            String argueTitle = argueMapper.getArgueTitleById(mapping.getKey());
            // 观点为空
            if (argueOpinion == null) {
                argueResponseVO.setArgueId(mapping.getKey());
                argueResponseVO.setArgueTitle(argueTitle);
                argueResponseVO.setRecommendArgueOpinionResponseVOList(null);
            } else {
                UserInfoPO userInfoById = argueMapper.getUserInfoById(argueOpinion.getUserId());
                argueResponseVO.setArgueId(mapping.getKey());
                argueResponseVO.setArgueTitle(argueTitle);
                RecommendArgueOpinionResponseVO reAORV = new RecommendArgueOpinionResponseVO();
                reAORV.setArgueOpinionId(argueOpinion.getId());
                reAORV.setUserId(userInfoById.getUserId());
                reAORV.setUsername(userInfoById.getUsername());
                reAORV.setAvatar(userInfoById.getAvatar());
                reAORV.setArgueOpinionContent(argueOpinion.getOpinionContent());
                reAORV.setArgueOpinionPosition(argueOpinion.getOpinionPosition());
                reAORV.setArgueOpinionCommentLikeCount(argueOpinion.getOpinionLikes());
                reAORV.setOpinionTime(argueOpinion.getCreateTime());
                argueResponseVO.setRecommendArgueOpinionResponseVOList(reAORV);
            }
            responseVOS.add(argueResponseVO);
        }
        BaseResponse baseResponse = new BaseResponse(200, "成功", responseVOS);

        return baseResponse;
    }
}
