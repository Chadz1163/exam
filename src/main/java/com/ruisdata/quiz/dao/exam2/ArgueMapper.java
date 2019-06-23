package com.ruisdata.quiz.dao.exam2;

import com.ruisdata.quiz.PO.ArgueOpinionPO;
import com.ruisdata.quiz.PO.ArguePO;
import com.ruisdata.quiz.PO.UserInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArgueMapper {

    /**
     * 获取话题列表
     * @return
     */
    List<ArguePO> getArgueList();

    /**
     * 根据用户id，获取用户信息
     * @param userId
     * @return
     */
    UserInfoPO getUserInfoById(@Param("userId") Long userId);

    /**
     * 根据话题id，查询点赞数最多的观点
     */
    ArgueOpinionPO getArgueOpinionByLikeCount(@Param("argueId") Long argueId);

    /**
     * 根据观点id获取观点数量
     * @return
     */
    Integer getArgueIdWithOpinionCount(@Param("argueId") Long argueId);

    /**
     * 根据话题id获取标题
     * @param argueId
     * @return
     */
    String getArgueTitleById(@Param("argueId") Long argueId);
}
