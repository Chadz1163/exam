package com.ruisdata.quiz.VO.response;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class RecommendArgueOpinionResponseVO {
    private Long argueOpinionId; // 观点id
    private Long userId; // 用户id
    private String username; // 用户昵称
    private String avatar; // 用户头像
    private byte argueOpinionPosition; // 观点立场
    private String argueOpinionContent; // 观点内容
    private Integer argueOpinionCommentLikeCount; // 观点点赞数
    private Timestamp opinionTime; // 创建时间
}
