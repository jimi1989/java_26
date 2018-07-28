package com.kaishengit.erp.controller;

import com.kaishengit.erp.controller.exceptionHandler.NotFoundException;
import com.kaishengit.erp.dto.ResponseBean;
import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.entity.Role;
import com.kaishengit.erp.entity.RolePermission;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Permission> permissionList = rolePermissionService.findAllPermission();
        model.addAttribute("permissionList", permissionList);

        return "manage/roles/new";
    }

    @PostMapping("/new")
    public String rolesNew(Role role, Integer[] permissionId) {
        rolePermissionService.saveRole(role, permissionId);
        return "redirect:/manage/roles";
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delRole(@PathVariable Integer id) {
        try {
            rolePermissionService.delRoleById(id);
            return ResponseBean.success();
        } catch (ServiceException e) {
            return ResponseBean.error(e.getMessage());
        }
    }

    @RequestMapping("/{id:\\d+}/edit")
    public String editRole(@PathVariable Integer id, Model model) {
        Role role = rolePermissionService.findRoleWithPermission(id);

        if(role == null) {
            throw new NotFoundException();
        }

        // 获得是否被checked的权限列表
        Map<Permission, Boolean> permissionBooleanMap = rolePermissionService.permissionBooleanMap(role.getPermissionList());

        model.addAttribute("permissionBooleanMap", permissionBooleanMap);
        model.addAttribute("role", role);
        return "/manage/roles/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editRoles(Role role,Integer[] permissionId) {
        rolePermissionService.editRole(role, permissionId);

        return "redirect:/manage/roles";
    }

}
