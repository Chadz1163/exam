package com.ruisdata.quiz.PO;

import lombok.Data;
import lombok.Getter;
@Data
public class ArguePO {

    private Long id; // id
    private String argueTitle; // 话题标题
    private String argueContent; // 话题内容
    private String arguePicture; // 话题图片
    private Integer argueParticipants; // 话题参与人数

}
