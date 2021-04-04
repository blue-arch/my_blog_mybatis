package com.blue.po.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Blue
 * @Date: 2021/4/4
 * @Time: 13:17
 * @Description:
 */
@Data
public class DetailedBlog {
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer view;
//    private Integer commentCount;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //Type
    private String typeName;
}
