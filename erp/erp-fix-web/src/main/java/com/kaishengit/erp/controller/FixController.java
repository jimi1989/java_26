package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.FixOrder;
import com.kaishengit.erp.service.FixOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
@Controller
@RequestMapping("/fix")
public class FixController {

    @Autowired
    private FixOrderService fixOrderService;

    @GetMapping("/home")
    public String home(Model model) {
        List<FixOrder> fixOrderList = fixOrderService.findFixOrderListWithParts();
        return "fix/home";
    }



}
