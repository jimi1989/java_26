package com.kaishengit.tms.client;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/27
 */
@FeignClient(name = "ROLE-PERMISSION-SERVICE")
public interface AccountServiceClient {

    @GetMapping("/account/{userMobile}")
    Account findByMobile(@PathVariable(name = "userMobile") String userMobile);

    @PostMapping("/account/login/log/save")
    void saveAccountLoginLog(AccountLoginLog accountLoginLog);

    @GetMapping("/roles/{accountId}")
    List<Roles> findRolesByAccountId(@PathVariable(name = "accountId") Integer accountId);

    @GetMapping("/permissions/{roleId}")
    List<Permission> findAllPermissionByRolesId(@PathVariable(name = "roleId") Integer roleId);

    @GetMapping("/permissions")
    List<Permission> findAllPermission();
}
