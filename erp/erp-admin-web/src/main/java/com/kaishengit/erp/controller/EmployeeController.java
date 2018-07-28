package com.kaishengit.erp.controller;

import com.google.common.collect.Maps;
import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.entity.Role;
import com.kaishengit.erp.service.EmployeeService;
import com.kaishengit.erp.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
@Controller
@RequestMapping("/manage/employee")
public class EmployeeController {

    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String home(Model model,
                       @RequestParam(required = false) Integer roleId,
                       @RequestParam(required = false) String nameMobile) {

        Map<String,Object> requestParam = Maps.newHashMap();
        requestParam.put("nameMobile",nameMobile);
        requestParam.put("roleId",roleId);
        List<Employee> employeeList = employeeService.findAllAccountWithRolesByQueryParam(requestParam);
        List<Role> roleList = rolePermissionService.findAllRoles();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("rolesList", roleList);
        return "manage/account/home";
    }

    /**
     * 新增账号
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newEmployee(Model model) {
        List<Role> roleList = rolePermissionService.findAllRoles();

        model.addAttribute("roleList",roleList);
        return "manage/account/new";
    }

    @PostMapping("/new")
    public String newAccount(Employee employee, Integer[] roleIds) {
        employeeService.saveEmployee(employee,roleIds);
        return "redirect:/manage/employee";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String employeeEdit(@PathVariable Integer id, Model model) {
        // 封装账号信息
        Employee employee = employeeService.findEmployeeById(id);

        // 封装所有角色列表
        List<Role> roleList = rolePermissionService.findAllRoles();
        // 封装当前账号拥有的角色列表
        List<Role> employeeRoleList = rolePermissionService.findRoleListByEmployeeId(id);

        model.addAttribute("employee", employee);
        model.addAttribute("roleList", roleList);
        model.addAttribute("employeeRoleList", employeeRoleList);
        return "manage/account/edit";
    }


}
