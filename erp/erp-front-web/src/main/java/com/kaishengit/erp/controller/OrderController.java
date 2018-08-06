package com.kaishengit.erp.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.kaishengit.erp.dto.ResponseBean;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.service.OrderService;
import com.kaishengit.erp.service.PartsService;
import com.kaishengit.erp.vo.OrderInfoVo;
import com.kaishengit.erp.vo.OrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/undone/list")
    public String undoneList(@RequestParam(name = "p",defaultValue = "1",required = false) Integer pageNo,
                            @RequestParam(required = false) String licenceNo,
                            @RequestParam(required = false) String tel,
                            @RequestParam(required = false) String startTime,
                            @RequestParam(required = false) String endTime,
                            Model model) {

        // 封装筛选的queryMap集合
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("pageNo", pageNo);
        queryMap.put("licenceNo", licenceNo);
        queryMap.put("tel", tel);
        queryMap.put("startTime", startTime);
        queryMap.put("endTime", endTime);
        queryMap.put("exState", Order.ORDER_STATE_DONE);


        PageInfo<Order> page = orderService.findPageByParam(queryMap);

        model.addAttribute("type","");
        model.addAttribute("page", page);
        return "order/list";
    }

    @GetMapping("/done/list")
    public String doneList(@RequestParam(name = "p",defaultValue = "1",required = false) Integer pageNo,
                           @RequestParam(required = false) String licenceNo,
                           @RequestParam(required = false) String tel,
                           @RequestParam(required = false) String startTime,
                           @RequestParam(required = false) String endTime,
                           Model model) {

        // 封装筛选的queryMap集合
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("pageNo", pageNo);
        queryMap.put("licenceNo", licenceNo);
        queryMap.put("tel", tel);
        queryMap.put("startTime", startTime);
        queryMap.put("endTime", endTime);

        queryMap.put("state", Order.ORDER_STATE_DONE);

        PageInfo<Order> page = orderService.findPageByParam(queryMap);
        model.addAttribute("type","done");
        model.addAttribute("page", page);
        return "order/hisList";
    }

    @GetMapping("/new")
    public String newOrder() {
        return "order/new";
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseBean newOrder(String json){
        // 将前端数据转化成对对象
        Gson gson = new Gson();
        OrderVo orderVo = gson.fromJson(json, OrderVo.class);
        // 获得当前登录的员工对象
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        orderService.newOrder(orderVo, employee.getId());
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

    @GetMapping("/{id:\\d+}/detail")
    public String orderDetail(@PathVariable Integer id, Model model) {
        // 获得订单信息
        Order order = orderService.findOrderById(id);

        // 获得订单服务类型信息
        ServiceType serviceType = orderService.findServiceTypeById(order.getServiceTypeId());

        // 获得订单配件列表
        List<Parts> partsList = partsService.findPartsByOrderId(order.getId());

        model.addAttribute("order", order);
        model.addAttribute("serviceType", serviceType);
        model.addAttribute("partsList", partsList);
        return "order/detail";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String orderEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("orderId", id);
        return "order/edit";
    }

    @GetMapping("/{id:\\d+}/info")
    @ResponseBody
    public ResponseBean orderInfo(@PathVariable Integer id) {
        try {
            // 获得订单信息
            Order order = orderService.findOrderById(id);

            // 获得订单服务类型信息
            ServiceType serviceType = orderService.findServiceTypeById(order.getServiceTypeId());

            // 获得订单配件列表
            List<Parts> partsList = partsService.findPartsByOrderId(order.getId());

            OrderInfoVo orderInfoVo = new OrderInfoVo();
            orderInfoVo.setOrder(order);
            orderInfoVo.setServiceType(serviceType);
            orderInfoVo.setPartsList(partsList);

            return ResponseBean.success(orderInfoVo);

        }catch (ServiceException e) {
            ResponseBean.error(e.getMessage());
        }
        return null;
    }

    @PostMapping("/{id:\\d+}/edit")
    @ResponseBody
    public ResponseBean orderEdit(String json) {
        // 将前端数据转化成对对象
        Gson gson = new Gson();
        OrderVo orderVo = gson.fromJson(json, OrderVo.class);
        try {
            orderService.editOrder(orderVo);
        }catch(ServiceException e) {
            return ResponseBean.error(e.getMessage());
        }
        return ResponseBean.success();
    }

    @GetMapping("/{id:\\d+}/trans")
    @ResponseBody
    public ResponseBean orderTrans(@PathVariable Integer id) {
        try {
            orderService.transOrder(id);
        } catch (ServiceException e) {
            return ResponseBean.error(e.getMessage());
        }
        return ResponseBean.success();
    }

}
