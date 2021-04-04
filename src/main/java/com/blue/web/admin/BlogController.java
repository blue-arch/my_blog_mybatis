package com.blue.web.admin;

import com.blue.po.Blog;
import com.blue.po.User;
import com.blue.po.vo.BlogQuery;
import com.blue.service.BlogService;
import com.blue.service.TagService;
import com.blue.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Blue
 * @Date: 2021/4/2
 * @Time: 21:12
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;
    /**
     * 后台显示博客列表
     *
     * @param pageNum  显示第几页
     * @param pageSize 每页展示的数量
     * @param model 前端model
     * @return
     */
    @GetMapping("/blogs")
    public String toBlogs(@RequestParam(defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "10") int pageSize,

                          Model model) {

        PageHelper.startPage(pageNum, pageSize);
        //传递一个空对象即可
        BlogQuery blog = new BlogQuery();
        List<Blog> lists = blogService.listBlog(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(lists);
        model.addAttribute("pages", blogPageInfo);
        model.addAttribute("types", typeService.listType());

        return "admin/blogs";
    }

    /**
     * 后台博客搜索功能
     *
     * @param pageNum
     * @param pageSize
     * @param blog
     * @param model
     * @return
     */
    @PostMapping("/blogs/search")
    //利用的是spring mvc里面的利用对象接收参数，只要保证请求参数名与这个对象的属性名称相同即可
    public String search(@RequestParam(defaultValue = "1") int pageNum,
                         @RequestParam(defaultValue = "10") int pageSize,
                         BlogQuery blog,
                         Model model) {

        PageHelper.startPage(pageNum, pageSize);
        // 根据BlogQuery对象的属性来进行查询
        List<Blog> lists = blogService.listBlog(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(lists);
        model.addAttribute("pages", blogPageInfo);
        model.addAttribute("types", typeService.listType());

        return "admin/blogs :: blogList";
    }

    /**
     * 博客编辑和发表
     *
     * @param model
     * @return
     */
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }



    /**
     * 更新编辑博客
     *
     * @param id    指定博客的id
     * @param model
     * @return
     */
    @GetMapping("/blogs/{id}/update")
    public String editBlog(@PathVariable long id, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        Blog blog = blogService.getBlogByID(id);
        model.addAttribute("blog", blog);
        return "admin/blogs-input";
    }

    /**
     * 保存或者发布博客
     *
     * @param blog
     * @param session
     * @param attributes
     * @return
     */
    @PostMapping("/blogs/save")
    public String save(Blog blog, HttpSession session, RedirectAttributes attributes) {
        // 获取当前用户(在login时放进去的)
        blog.setUser((User) session.getAttribute("user"));
        //前端传入type.id之后就要设置当前博客的type了
        blog.setType(typeService.getType(blog.getType().getId()));
        //把前端传来的标签封装进blog里面
        blog.setTages(tagService.listTag(blog.getTagIds()));
        //最后再保存博客
        int save = blogService.save(blog);
        if (save > 0) {
            attributes.addFlashAttribute("msg", "操作成功");
        } else {
            attributes.addFlashAttribute("msg", "操作失败");
        }

        return "redirect:/admin/blogs";
    }
    /**
     * 更新博客
     *
     * @param blog
     * @param session
     * @param attributes
     * @return
     */
    @PostMapping("/updateBlogs")
    public String updateBlogs(Blog blog, HttpSession session, RedirectAttributes attributes) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTages(tagService.listTag(blog.getTagIds()));
        int update = blogService.updateBlog(blog);
        if (update > 0) {
            attributes.addFlashAttribute("msg", "操作成功");

        } else {
            attributes.addFlashAttribute("msg", "操作失败");
        }

        return "redirect:/admin/blogs";
    }




}
