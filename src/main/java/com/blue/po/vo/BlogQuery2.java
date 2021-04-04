package com.blue.po.vo;

import com.blue.po.Type;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 显示数据实体类
 * @Author: ONESTAR
 * @Date: Created in 15:20 2020/3/31
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
public class BlogQuery2 {

    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;


}