package com.kaishengit.erp.controller;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
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
        // 排除当前permission对象及其子权限对象
        remove(menuPermissionList,permission);

        model.addAttribute("menuPermissionList", menuPermissionList);
        model.addAttribute("permission", permission);
        return "manage/permission/edit";
    }

    /**
     * 递归去除所有的子权限
     * @param menuPermissionList 源list
     * @param permission 要去除的权限对象
     */
    private void remove(List<Permission> menuPermissionList, Permission permission) {
        // 通过临时变量来存储所有的list元素防止漏删
        List<Permission> temp = Lists.newArrayList(menuPermissionList);
        for(int i = 0; i < temp.size(); i++) {
            // 判断有没有子权限要去除
            if(temp.get(i).getPid().equals(permission.getId())) {
                remove(menuPermissionList,temp.get(i));
            }
        }
        // 去除当前权限
        menuPermissionList.remove(permission);
    }

    @PostMapping("/{id:\\d+}/edit")
    public String permissionEdit(Permission permission) {
        rolePermissionService.editPermission(permission);
        return "redirect:/manage/permission";
    }

}
