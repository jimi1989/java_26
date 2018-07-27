package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.entity.Role;
import com.kaishengit.erp.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
@Controller
@RequestMapping("/manage/roles")
public class RolesController {

    @Autowired
    private RolePermissionService rolePermissionService;


    @GetMapping
    public String home(Model model){
        List<Role> roleList = rolePermissionService.findRoleListWithPermission();
        model.addAttribute("roleList", roleList);
        return "manage/roles/home";
    }

    @GetMapping("/new")
    public String rolesNew(Model model) {
        List<Permission> permissionList = rolePermissionService.findList();
        model.addAttribute("permissionList", permissionList);

        return "manage/roles/new";
    }

    @PostMapping("/new")
    public String rolesNew(Role role, Integer[] permissionId) {
        rolePermissionService.saveRole(role, permissionId);
        return "redirect:/manage/roles";
    }


}
