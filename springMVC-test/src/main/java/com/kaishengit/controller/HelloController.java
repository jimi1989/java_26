package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jinjianghao
 * @date 2018/7/19
 */
@Controller
public class HelloController {

    // @RequestMapping(value = "/hello", method = {RequestMethod.POST,RequestMethod.GET})
    @GetMapping("/hello")
    @PostMapping("/hello")
    public String hello() {
        System.out.println("hello,springMvc");
        return "hello";
    }

}
