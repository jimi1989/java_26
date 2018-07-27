package com.kaishengit.erp.service.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.PermissionMapper;
import com.kaishengit.erp.mapper.RoleMapper;
import com.kaishengit.erp.mapper.RolePermissionMapper;
import com.kaishengit.erp.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 新增权限
     *
     * @param permission 权限对象
     */
    @Override
    public void savePermission(Permission permission) {
        permissionMapper.insertSelective(permission);
    }

    /**
     * 根据权限类型查询对应的集合列表
     *
     * @param permissionType 权限类型
     * @return
     */
    @Override
    public List<Permission> findPermissionListByType(String permissionType) {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(permissionType);

        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 查询所有的权限列表
     *
     * @return
     */
    @Override
    public List<Permission> findList() {
        PermissionExample permissionExample = new PermissionExample();

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> endList = new ArrayList<>();
        treeList(permissionList, endList, 0);
        return endList;
    }

    /**
     * 将查询数据库的角色列表转换为树形集合结果
     * @param sourceList 数据库查询出的集合
     * @param endList 转换结束的结果集合
     * @param parentId 父ID
     */
    private void treeList(List<Permission> sourceList, List<Permission> endList, int parentId) {
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(sourceList, new Predicate<Permission>() {
            @Override
            public boolean apply(Permission permission) {
                return permission.getPid().equals(parentId);
            }
        }));

        for(Permission permission : tempList) {
            endList.add(permission);
            treeList(sourceList,endList,permission.getId());
        }
    }

    /**
     * 根据id查找对应的权限对象
     *
     * @param id
     * @return permission
     */
    @Override
    public Permission findPermissionById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }


    /**
     * 新增角色
     *
     * @param role
     * @param permissionIds 关联的权限id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveRole(Role role, Integer[] permissionIds) {
        // 新增角色
        roleMapper.insertSelective(role);
        // 新增角色权限关联关系
        for(Integer permissionId : permissionIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(role.getId());
            rolePermission.setPermissionId(permissionId);

            rolePermissionMapper.insert(rolePermission);
        }
    }

    /**
     * 查询所有的带权限的角色列表
     *
     * @return
     */
    @Override
    public List<Role> findRoleListWithPermission() {
        List<Role> roleList = roleMapper.findListWithPermission();
        return roleList;
    }

    /**
     * 根据id删除权限
     *
     * @param id
     */
    @Override
    public void delPermission(Integer id) throws ServiceException {
        // 1.如果是父权限，并且拥有子权限，则不能删除
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPidEqualTo(id);
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        if(permissionList != null && permissionList.size() > 0) {
            throw new ServiceException("该权限下有子权限，不能删除");
        }

        // 2.如果该权限被角色所使用不能删除
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andPermissionIdEqualTo(id);

        List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionExample);

        if(rolePermissionList != null && rolePermissionList.size() > 0) {
            throw new ServiceException("该权限正在被使用，不能删除");
        }

        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editPermission(Permission permission) {
        // 设置更新时间
        permission.setUpdateTime(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);
    }


}
