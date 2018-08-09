package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.entity.FixOrder;
import com.kaishengit.erp.service.FixOrderService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/list")
    public String home(Model model) {
        List<FixOrder> fixOrderList = fixOrderService.findFixOrderListWithParts();
        model.addAttribute("fixOrderList", fixOrderList);
        return "fix/list";
    }

    @GetMapping("/{id:\\d+}/receive")
    public String receiveTask(@PathVariable Integer id) {
        // 获得当前登录的员工对象
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        fixOrderService.taskReceive(id, employee);
        return "redirect:/fix/" + id + "/detail";
    }

    @GetMapping("/{id:\\d+}/detail")
    public String serviceTask(@PathVariable Integer id, Model model) {
        FixOrder fixOrder = fixOrderService.getFixOrder(id);
        // 获得当前登录的员工对象
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();

        model.addAttribute("curr_employee_id", employee.getId());
        model.addAttribute("fixOrder", fixOrder);
        return "fix/detail";
    }

}
