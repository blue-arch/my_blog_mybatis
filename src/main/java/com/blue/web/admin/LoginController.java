package com.blue.web.admin;

import com.blue.po.User;
import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: Blue
 * @Date: 2021/4/2
 * @Time: 19:47
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 判断是否登录，若没登录跳转至登录页面
     *
     * @param httpSession
     * @return
     */
    @GetMapping
    public String toLogin(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            return "redirect:/admin/index";
        }

        return "admin/login";
    }

    /**
     * 跳转至后台管理首页
     *
     * @param
     * @return
     */
    @GetMapping("/index")
    public String toAdminIndex() {

        return "admin/index";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            httpSession.setAttribute("user", user);
            return "redirect:/admin/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "用户名或者密码错误");

            return "redirect:/admin";
        }

    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
