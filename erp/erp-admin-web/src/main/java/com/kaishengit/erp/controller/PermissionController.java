package com.kaishengit.erp.controller;

import com.kaishengit.erp.controller.exceptionHandler.NotFoundException;
import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.service.RolePermissionService;
import com.kaishengit.erp.dto.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
@Controller
@RequestMapping("/manage/permission")
public class PermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping
    public String home(Model model) {
        List<Permission> permissionList = rolePermissionService.findAllPermission();
        model.addAttribute("permissionList", permissionList);
        return "manage/permission/home";
    }

    @GetMapping("/new")
    public String permissionNew(Model model) {
        // 封装所有菜单权限列表
        List<Permission> menuPermissionList = rolePermissionService.findPermissionListByType(Permission.PERMISSION_TYPE_MENU);
        model.addAttribute("menuPermissionList", menuPermissionList);

        return "manage/permission/new";
    }

    @PostMapping("/new")
    public String permissionNew(Permission permission) {
        rolePermissionService.savePermission(permission);
        return "redirect:/manage/permission";
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean permissionDel(@PathVariable Integer id) {
        try {
            rolePermissionService.delPermission(id);
        } catch (ServiceException e) {
            return ResponseBean.error(e.getMessage());
        }
        return ResponseBean.success();
    }

    @GetMapping("/{id:\\d+}/edit")
    public String permissionEdit(@PathVariable Integer id, Model model) {
        Permission permission = rolePermissionService.findPermissionById(id);

        if(permission == null) {
            throw new NotFoundException();
        }

        // 封装所有菜单权限列表
        List<Permission> menuPermissionList = rolePermissionService.findPermissionListByType(Permission.PERMISSION_TYPE_MENU);
        // 排除当前permission对象
        menuPermissionList.remove(permission);

        model.addAttribute("menuPermissionList", menuPermissionList);
        model.addAttribute("permission", permission);
        return "manage/permission/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String perMissionEdit(Permission permission) {
        rolePermissionService.editPermission(permission);
        return "redirect:/manage/permission";
    }

}
