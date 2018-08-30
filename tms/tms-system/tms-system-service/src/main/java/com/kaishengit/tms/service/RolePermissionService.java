package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.exception.ServiceException;

import java.util.List;

/**
 * 角色和权限的业务类
 * @author jinjianghao
 */
public interface RolePermissionService {

    /**
     * 添加权限
     * @param permission
     */
    void savePermission(Permission permission);

    /**
     * 根据权限类型查询权限列表
     * @param permissionType 权限类型 菜单|按钮
     * @return 对应的权限列表
     */
    List<Permission> findPermissionByPermissionType(String permissionType);

    /**
     * 查询所有的权限
     * @return
     */
    List<Permission> findAllPermission();

    /**
     * 新增角色
     * @param roles 角色对象
     * @param permissionId 角色对应的权限ID列表
     */
    void saveRoles(Roles roles, Integer[] permissionId);

    /**
     * 根据权限ID删除权限
     * @param id
     * @throws ServiceException 删除失败抛出此异常，例如权限已经被角色使用
     */
    void delPermissionById(Integer id) throws ServiceException;

    /**
     * 查询所有的角色并加载角色拥有的权限列表
     * @return
     */
    List<Roles> findAllRolesWithPermission();

    /**
     * 根据角色主键删除角色
     * @param id
     * @throws ServiceException
     */
    void delRolesById(Integer id) throws ServiceException;

    /**
     * 根据角色ID查询角色对象及其拥有的权限
     * @param id
     * @return
     */
    Roles findRolesWithPermissionById(Integer id);

    /**
     * 修改角色对象
     * @param roles 角色对象
     * @param permissionId 角色拥有的新权限ID数组
     */
    void updateRoles(Roles roles, Integer[] permissionId);

    /**
     * 查询所有的角色
     */
    List<Roles> findAllRoles();

    /**
     * 根据账号ID查询拥有的角色集合
     * @param id 账号ID
     * @return
     */
    List<Roles> findRolesByAccountId(Integer id);

    /**
     * 根据角色ID查询所有的对应的权限
     * @param rolesId 角色ID
     * @return
     */
    List<Permission> findAllPermissionByRolesId(Integer rolesId);

    /**
     * 根据id查找对应的权限对象
     * @param id
     * @return permission
     */
    Permission findPermissionById(Integer id);

    /**
     * 根据权限类型查询对应的集合列表
     * @param permissionTypeMenu
     * @return
     */
    List<Permission> findPermissionListByType(String permissionTypeMenu);

    /**
     * 更新权限
     * @param permission
     */
    void editPermission(Permission permission);
}
