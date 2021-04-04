package com.blue.po.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Blue
 * @Date: 2021/4/3
 * @Time: 22:17
 * @Description:
 */
@Data
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer view;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}
