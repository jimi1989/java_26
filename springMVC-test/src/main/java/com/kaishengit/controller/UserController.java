package com.kaishengit.controller;

import com.kaishengit.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/20
 */
// @Controller
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String index() {
        return "user/index";
    }

    @GetMapping("/new")
    public String addUser(@CookieValue(name = "userName") String name, Model model,@RequestHeader(name="user-Agent") String userAgent) {
        model.addAttribute("name", name);
        System.out.println(userAgent);
        return "user/new";
    }

    @PostMapping("/new")
    public String addUser(User user, String tel, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        // cookie存值
        Cookie cookie = new Cookie("userName", user.getUsername());

        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setHttpOnly(true);

        resp.addCookie(cookie);

        // session.getAttribute("curr_admin");
        /*String tel1 = req.getParameter("tel");
        System.out.println(tel1);*/

        /*HttpSession session1 = req.getSession();
        ServletContext context = req.getServletContext();*/

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
    public String showUser(@RequestParam(name = "pageNo", defaultValue = "1") Integer p,
            @PathVariable(name = "id") Integer userId, Model model) {
        System.out.println("pageNo:" + p);
        System.out.println("get user..." + userId);
        model.addAttribute("userId",userId);
        return "user/home";
    }

    @GetMapping("/{type:v-.+}/{id:\\d+}")
    public ModelAndView showUser(
            String name,
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

        /*try {
            name = new String(name.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        System.out.println("name:" + name);
        return modelAndView;
    }

//    @GetMapping(value = "/save", produces = "text/plain;charset=UTF-8")
    @RequestMapping(value = "/save",method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveUser() {
        System.out.println("save success！");
        return "保存成功";
    }

    @GetMapping("/{id:\\d+}.json")
    @ResponseBody
    public User showUser(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("jack");
        user.setAddress("beijing");
        return user;
    }


    @GetMapping("/list.json")
    @ResponseBody
    public List<User> allUser() {
        List<User> userList = Arrays.asList(
                new User(10011, "jack", "newyork"),
                new User(10012, "rose", "newyork"),
                new User(10013, "tom", "newyork")
        );
        return userList;

    }

}
