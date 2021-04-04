package com.blue.web.front;

import com.blue.po.vo.BlogQuery;
import com.blue.po.vo.DetailedBlog;
import com.blue.po.vo.FirstPageBlog;
import com.blue.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 17208
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LinkService linkService;


    //    @GetMapping("/")
//    public String index() throws NotFoundException {
////        String blog = null;
////        if(blog == null) {
////            throw new BlogNotFoundException("博客不存在");
////        }
////        System.out.println("-------------index-------------------");
//
//        return "index";
//    }
//    @GetMapping("/blog")
//    public String blog() throws NotFoundException {
////        String blog = null;
////        if(blog == null) {
////            throw new BlogNotFoundException("博客不存在");
////        }
////        System.out.println("-------------index-------------------");
//
//        return "admin/index";
//    }
    @GetMapping({"/blog", "/"})
    public String blog(@RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "8") int pageSize,
                       BlogQuery blog,
                       Model model) {

        PageHelper.startPage(pageNum, pageSize);
        List<FirstPageBlog> lists = blogService.getAllFirstPageBlog();

        PageInfo<FirstPageBlog> blogPageInfo = new PageInfo<>(lists);
//        System.out.println(lists.size()+"0-0-0-0-0-0-0-0-0-0-0-0-0-=00000");
        model.addAttribute("blogs", blogPageInfo);
        model.addAttribute("tags", tagService.getAllTagAndBlog());
        model.addAttribute("types",typeService.getAllTypeAndBlog());
//        model.addAttribute("comments", commentService.listAllComments());
        model.addAttribute("hotBlogs", blogService.listBlogOnFrontHot(blog));
        model.addAttribute("links", linkService.listAllOnFront());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "1") int pageNum,
                         @RequestParam(defaultValue = "5") int pageSize,
                         @RequestParam("keyword") String keyword,
                         Model model) {
//        BlogQuery blogQuery = new BlogQuery();
//        blogQuery.setTitle(keyword);
        PageHelper.startPage(pageNum, pageSize);
        List<FirstPageBlog> blogs = blogService.getSearchBlog(keyword);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("blogs", pageInfo);
        model.addAttribute("keyword", keyword);
//        model.addAttribute("hotBlogs", blogService.listBlogOnFrontHot(new BlogQuery()));
//        model.addAttribute("links", linkService.listAllOnFront());
        return "search";
    }

    //    跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
//        List<Comment> comments = commentService.listCommentByBlogId(id);
//        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }






}
