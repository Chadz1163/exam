package com.ruisdata.quiz.VO.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;



@Data
@ApiModel
public class ArgueResponseVO {

    private Long argueId; // argueId
    private String argueTitle; // 话题标题
    private RecommendArgueOpinionResponseVO recommendArgueOpinionResponseVOList;




}
