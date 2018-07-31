package com.kaishengit.erp.controller;

import com.kaishengit.erp.service.EmployeeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页控制器，跳转首页、登录、登出系统
 * @author jinjianghao
 * @date 2018/7/26
 */
@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String login() {
        Subject subject = SecurityUtils.getSubject();

        // 判断当前是否已经通过认证，如果通过则退出登录
        if(subject.isAuthenticated()) {
            subject.logout();
        }

        if(subject.isRemembered()) {
            return "home";
        }
        return "index";
    }

    @PostMapping("/")
    public String login(String userTel,
                        String password,
                        String remember,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes){

        // 创建subject主体对象
        Subject subject = SecurityUtils.getSubject();
        // 获得登录的IP
        String loginIp = request.getRemoteAddr();
        // 通过userTel、password封装UsernamePasswordToken对象进行登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userTel, DigestUtils.md5Hex(password),remember != null ,loginIp);

        try {
            subject.login(usernamePasswordToken);

            // 判断跳转路径
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";
            if(savedRequest != null) {
                // 获得callback的url
                url = savedRequest.getRequestUrl();
            }

            return "redirect:" + url;
        }catch (UnknownAccountException|IncorrectCredentialsException e) {
            redirectAttributes.addFlashAttribute("message", "用户名或者密码错误");
        } catch (LockedAccountException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message", "登录失败");
        }
        return "redirect:/";

    }


    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }

}
