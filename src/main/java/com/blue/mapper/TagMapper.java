package com.blue.mapper;

import com.blue.po.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/7 8:37 上午
 */
@Mapper
@Repository
public interface TagMapper {

    int save(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTag1(@Param("ids") List<Long> ids);

    int updateTag(Tag tag);

    int deleteTag(Long id);

    List<Tag> getAllTagAndBlog();
}
