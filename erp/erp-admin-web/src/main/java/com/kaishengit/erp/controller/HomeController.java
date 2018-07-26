package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "index";
    }

    @PostMapping("/")
    public String login(String userTel,
                        String password,
                        String remember,
                        HttpSession session,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes){
        // 获得请求的ip
        String loginIp = request.getRemoteAddr();

        try {
            Employee employee = employeeService.login(userTel, password, loginIp);
            session.setAttribute("curr_emp", employee);
            return "redirect:/home";
        }catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }

    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        // session强制退出
        session.invalidate();
    }


}
