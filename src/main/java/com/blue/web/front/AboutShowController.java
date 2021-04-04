package com.blue.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Blue
 * @Date: 2021/4/4
 * @Time: 19:10
 * @Description:
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
