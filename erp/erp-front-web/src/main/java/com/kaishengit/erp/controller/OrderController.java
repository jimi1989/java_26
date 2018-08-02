package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * @author jinjianghao
 * @date 2018/8/1
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    public String undoneList() {

        return "order/list";
    }

    @GetMapping("/new")
    public String newOrder() {
        return "order/new";
    }

    @PostMapping("/new")
    public String newOrder(Order order){

        return "";
    }

}
