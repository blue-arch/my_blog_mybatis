package com.blue.service;


import com.blue.po.Tag;

import java.util.List;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/7 8:35 上午
 */
public interface TagService {

    int save(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTag(List<Long> ids);

    int updateTag(Tag tag);

    int deleteTag(Long id);

    List<Tag> getAllTagAndBlog();

}
