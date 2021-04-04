package com.blue.mapper;

import com.blue.po.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/4 5:29 下午
 */
@Mapper
@Repository
public interface UserMapper {

    User userCheck(@Param("name") String username, @Param("word") String password);
}
