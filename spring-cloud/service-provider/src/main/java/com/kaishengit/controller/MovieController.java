package com.kaishengit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinjianghao
 * @date 2018/8/23
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("/{id:\\d+}")
    public String findById(@PathVariable Integer id) {
        return "大话西游";
    }

}
