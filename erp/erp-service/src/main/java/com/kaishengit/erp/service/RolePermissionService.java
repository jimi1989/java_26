package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.entity.Role;
import com.kaishengit.erp.exception.ServiceException;

import java.util.List;

/**
 * 权限控制的业务层
 * @author jinjianghao
 * @date 2018/7/27
 */
public interface RolePermissionService {

    /**
     * 新增权限
     * @param permission 权限对象
     */
    void savePermission(Permission permission);

    /**
     * 根据权限类型查询对应的集合列表
     * @param permissionTypeMenu
     * @return
     */
    List<Permission> findPermissionListByType(String permissionTypeMenu);

    /**
     * 查询所有的权限列表
     * @return
     */
    List<Permission> findList();


    /**
     * 根据id查找对应的权限对象
     * @param id
     * @return permission
     */
    Permission findPermissionById(Integer id);

    /**
     * 新增角色
     * @param role
     * @param permissionIds 关联的权限id
     */
    void saveRole(Role role, Integer[] permissionIds);

    /**
     * 查询所有的带权限的角色列表
     * @return
     */
    List<Role> findRoleListWithPermission();

    /**
     * 根据id删除权限
     * @param id
     */
    void delPermission(Integer id) throws ServiceException;

    /**
     * 更新权限
     * @param permission
     */
    void editPermission(Permission permission);
}
