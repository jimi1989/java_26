package com.kaishengit.erp.controller;

import com.google.gson.Gson;
import com.kaishengit.erp.dto.ResponseBean;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.entity.ServiceType;
import com.kaishengit.erp.entity.Type;
import com.kaishengit.erp.service.OrderService;
import com.kaishengit.erp.service.PartsService;
import com.kaishengit.erp.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/2
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PartsService partsService;

    @GetMapping("/list")
    public String undoneList() {

        return "order/list";
    }

    @GetMapping("/new")
    public String newOrder() {
        return "order/new";
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseBean newOrder(String json){
        System.out.println(json);
        Gson gson = new Gson();
        OrderVo orderVo = gson.fromJson(json, OrderVo.class);
        System.out.println(orderVo);
        return ResponseBean.success();
    }

    @GetMapping("/service/types")
    @ResponseBody
    public ResponseBean serviceTypes() {
        List<ServiceType> ServiceTypeList = orderService.findAllServiceType();
        return ResponseBean.success(ServiceTypeList);
    }

    @GetMapping("/parts/types")
    @ResponseBody
    public ResponseBean partsTypes() {
        List<Type> typeList = orderService.findAllPartsType();
        return ResponseBean.success(typeList);
    }

    @GetMapping("/{id:\\d+}/parts")
    @ResponseBody
    public ResponseBean partsByType(@PathVariable Integer id) {
        List<Parts> partsList = partsService.findPartsByType(id);
        return ResponseBean.success(partsList);
    }

}
