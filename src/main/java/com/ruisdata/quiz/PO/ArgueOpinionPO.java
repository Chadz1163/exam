package com.ruisdata.quiz.PO;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class ArgueOpinionPO {

    private Long id; // 观点id
    private Long argueId; // 话题id
    private Long userId; // 用户id
    private byte opinionPosition; // 观点立场
    private String opinionContent; // 观点内容
    private Integer opinionLikes; // 观点点赞数
    private Timestamp createTime; // 创建时间
}
