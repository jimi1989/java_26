package com.kaishengit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinjianghao
 * @date 2018/9/3
 */
@RestController
public class MovieController {

    @GetMapping("/movie/{id:\\d+}")
    public String getMovieName(@PathVariable  Integer id) {
        System.out.println("id:-------->" + id);
        return "大话西游2";
    }

}
