package com.kaishengit.controller;

import com.kaishengit.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jinjianghao
 * @date 2018/7/20
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/new")
    public String addUser() {

        return "user/new";
    }

    @PostMapping("/new")
    public String addUser(User user, String tel) {
        System.out.println("username:" + user.getUsername());
        System.out.println("address:" + user.getAddress());
        System.out.println("tel:" + tel);
        return "redirect:/user/home";
    }

    /*@PostMapping("/new")
    public String addUser(String username, String address) {
        System.out.println("username:" + username);
        System.out.println("address:" + address);
        return "redirect:/user/home";
    }*/

    @GetMapping("/home")
    public String home() {
        // xxx...
        return "user/home";
    }

    @GetMapping("/{id:\\d+}")
    public String showUser(@RequestParam(defaultValue = "1") Integer p,
            @PathVariable(name = "id") Integer userId, Model model) {
        System.out.println("pageNo:" + p);
        System.out.println("get user..." + userId);
        model.addAttribute("userId",userId);
        return "user/home";
    }

    @GetMapping("/{type:v-\\d+}/{id:\\d+}")
    public ModelAndView showUser(
            @PathVariable String type,
            @PathVariable(name = "id") Integer userId) {
       /* ModelAndView modelAndView = new ModelAndView();
        // 视图设置
        modelAndView.setViewName("user/home");*/
        ModelAndView modelAndView = new ModelAndView("user/home");
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("type",type);

        System.out.println("userId: " + userId);
        System.out.println("userType: " + type);
        return modelAndView;
    }

}
