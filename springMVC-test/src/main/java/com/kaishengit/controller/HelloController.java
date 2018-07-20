package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author jinjianghao
 * @date 2018/7/19
 */
@Controller
public class HelloController {

    // @RequestMapping(value = "/hello", method = {RequestMethod.POST,RequestMethod.GET})
    @GetMapping("/hello2")
    //@PostMapping("/hello2")
    public String hello() {
        System.out.println("hello,springMvc");
        return "hello";
    }



}
