package com.blue.service;

import com.blue.po.Blog;
import com.blue.po.vo.BlogQuery;
import com.blue.po.vo.BlogQuery2;
import com.blue.po.vo.DetailedBlog;
import com.blue.po.vo.FirstPageBlog;

import java.util.List;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/7 9:14 上午
 */
public interface BlogService {

    Blog getBlogByID(Long id);

    Blog getBlogOnfront(Long id);

    int save(Blog blog);

    List<BlogQuery2> getAllBlog();

//    List<Blog> getAllBlog();
    //查出所有博客
    List<Blog> listBlog(BlogQuery blog);

    List<Blog> listBlogOnFront(BlogQuery blog);

    //热门文章
    List<Blog> listBlogOnFrontHot(BlogQuery blog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    //实现博客阅读数的增加
    int incView(long id);

    //批量增加博客喜欢数
    int incLikes();

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);


}
