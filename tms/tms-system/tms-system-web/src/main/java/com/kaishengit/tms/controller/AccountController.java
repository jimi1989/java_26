package com.kaishengit.tms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.kaishengit.tms.controller.exception.NotFoundException;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号管理控制器
 * @author jinjianghao
 */
@Controller
@RequestMapping("/manage/account")
public class AccountController {

    @Reference(version = "1.0")
    private RolePermissionService rolePermissionService;

    @Reference(version = "1.0")
    private AccountService accountService;

    @GetMapping
    public String home(Model model,
                       @RequestParam(required = false) Integer rolesId,
                       @RequestParam(required = false) String nameMobile) {

        Map<String,Object> requestParam = Maps.newHashMap();
        requestParam.put("nameMobile",nameMobile);
        requestParam.put("rolesId",rolesId);

        model.addAttribute("accountList",accountService.findAllAccountWithRolesByQueryParam(requestParam));
        model.addAttribute("rolesList",rolePermissionService.findAllRoles());
        return "manage/account/home";
    }

    /**
     * 新增角色
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newAccount(Model model) {
        List<Roles> rolesList = rolePermissionService.findAllRoles();

        model.addAttribute("rolesList",rolesList);
        return "manage/account/new";
    }

    @PostMapping("/new")
    public String newAccount(Account account, Integer[] rolesIds) {
        accountService.saveAccount(account,rolesIds);
        return "redirect:/manage/account";
    }

    /**
     * 修改账号
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateAccount(@PathVariable Integer id,Model model) {
        Account account = accountService.findById(id);
        if(account == null) {
            throw new NotFoundException();
        }
        //查询所有的角色
        List<Roles> rolesList = rolePermissionService.findAllRoles();
        //当前账号拥有的角色
        List<Roles> accountRolesList = rolePermissionService.findRolesByAccountId(id);

        model.addAttribute("rolesList",checkRolesListIsChecked(rolesList, accountRolesList));
        model.addAttribute("account",account);
        return "manage/account/edit";
    }

    /**
     * 转换为带是否选中的map集合
     * @param rolesList
     * @param accountRolesList
     * @return
     */
    private Map<Roles,Boolean> checkRolesListIsChecked(List<Roles> rolesList,List<Roles> accountRolesList) {
        Map<Roles,Boolean> map = new LinkedHashMap<>();
        for(Roles roles : rolesList) {
            boolean flag = false;
            for (Roles accountRoles : accountRolesList) {
                if(accountRoles.getId().equals(roles.getId())) {
                    flag = true;
                }
            }
            map.put(roles,flag);
        }
        return map;
    }

    @PostMapping("/{id:\\d+}/edit")
    public String updateAccount(Account account, Integer[] rolesIds, RedirectAttributes redirectAttributes) {
        accountService.updateAccount(account,rolesIds);
        redirectAttributes.addFlashAttribute("message","修改账号成功");
        return "redirect:/manage/account";
    }
}
