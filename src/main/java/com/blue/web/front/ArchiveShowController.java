package com.blue.web.front;

import com.blue.po.vo.BlogQuery;
import com.blue.po.vo.BlogQuery2;
import com.blue.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: Blue
 * @Date: 2021/4/4
 * @Time: 18:37
 * @Description:
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        List<BlogQuery2> blogs = blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "archives";
    }

}