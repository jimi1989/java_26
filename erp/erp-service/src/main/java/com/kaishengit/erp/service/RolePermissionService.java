package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.entity.Role;
import com.kaishengit.erp.exception.ServiceException;

import java.util.List;
import java.util.Map;

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
    List<Permission> findAllPermission();


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

    /**
     * 根据id删除角色
     * @param id
     * @throws ServiceException
     */
    void delRoleById(Integer id) throws ServiceException;

    /**
     * 根据id查找角色附带角色的权限列表
     * @return role
     */
    Role findRoleWithPermission(Integer id);

    /**
     * 在编辑页面判断当前权限的复选框是否被checked
     * @param rolesPermissionList 当前角色拥有的权限
     * @return 有顺序的map集合，如果被选择则value为true
     */
    Map<Permission, Boolean> permissionBooleanMap(List<Permission> rolesPermissionList);

    /**
     * 更新角色
     * @param role
     * @param permissionId
     */
    void editRole(Role role, Integer[] permissionId);


    /**
     * 获得所有的角色列表
     * @return
     */
    List<Role> findAllRoles();

    /**
     * 查找id具有的角色列表
     * @param id
     * @return
     */
    List<Role> findRoleListByEmployeeId(Integer id);
}
