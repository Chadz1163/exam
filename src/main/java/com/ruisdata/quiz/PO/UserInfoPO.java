package com.ruisdata.quiz.PO;

import lombok.Data;
import lombok.Getter;

@Data
public class UserInfoPO {

    private Long userId; // 用户id
    private String username; // 用户名
    private String avatar; // 用户头像
}
