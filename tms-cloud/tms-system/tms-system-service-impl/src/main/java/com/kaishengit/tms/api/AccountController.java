package com.kaishengit.tms.api;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/27
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping("/account/{userMobile}")
    public Account findByMobile(@PathVariable String userMobile) {
        return accountService.findByMobile(userMobile);
    }

    @PostMapping("/account/login/log/save")
    public void saveLoginLog(@RequestBody AccountLoginLog accountLoginLog) {
        accountService.saveAccountLoginLog(accountLoginLog);
    }

    @GetMapping("/roles/{accountId}")
    public List<Roles> findRolesByAccountId(@PathVariable Integer id){
        return rolePermissionService.findRolesByAccountId(id);
    }

    @GetMapping("/permissions/{roleId}")
    public List<Permission> findAllPermissionByRolesId(Integer roleId){
        return rolePermissionService.findAllPermissionByRolesId(roleId);
    }

    @GetMapping("/permissions")
    public List<Permission> findAllPermission(){
        return rolePermissionService.findAllPermission();
    }

}
