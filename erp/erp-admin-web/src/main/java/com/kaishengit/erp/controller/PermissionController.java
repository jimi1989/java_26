package com.kaishengit.erp.controller;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.service.RolePermissionService;
import com.kaishengit.erp.dto.ResppnseBean;
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
        List<Permission> permissionList = rolePermissionService.findList();
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
    public ResppnseBean permissionDel(@PathVariable Integer id) {
        try {
            rolePermissionService.delPermission(id);
        } catch (ServiceException e) {
            return ResppnseBean.error(e.getMessage());
        }
        return ResppnseBean.success();
    }

}
