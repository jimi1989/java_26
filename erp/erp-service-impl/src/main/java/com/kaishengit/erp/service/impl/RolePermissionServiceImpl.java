package com.kaishengit.erp.service.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.EmployeeRoleMapper;
import com.kaishengit.erp.mapper.PermissionMapper;
import com.kaishengit.erp.mapper.RoleMapper;
import com.kaishengit.erp.mapper.RolePermissionMapper;
import com.kaishengit.erp.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;


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
    public List<Permission> findAllPermission() {
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

        Permission permission = permissionMapper.selectByPrimaryKey(id);
        if(permission != null) {
            permissionMapper.deleteByPrimaryKey(id);
            logger.info("删除权限 {}", permission);
        }
    }

    @Override
    public void editPermission(Permission permission) {
        // 设置更新时间
        permission.setUpdateTime(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);

        logger.info("更新权限 {}",permission);
    }

    /**
     * 根据id删除角色
     *
     * @param id
     * @throws ServiceException
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delRoleById(Integer id) throws ServiceException {
        //查询是否被账号引用，如果引用则不能删除
        EmployeeRoleExample employeeRoleExample = new EmployeeRoleExample();
        employeeRoleExample.createCriteria().andRoleIdEqualTo(id);
        List<EmployeeRole> employeeRoleList = employeeRoleMapper.selectByExample(employeeRoleExample);

        if(employeeRoleList != null && !employeeRoleList.isEmpty()) {
            throw new ServiceException("该角色被账号引用，不能删除");
        }

        //删除角色和权限的关系记录
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(id);

        rolePermissionMapper.deleteByExample(rolePermissionExample);

        //删除角色
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role != null) {
            roleMapper.deleteByPrimaryKey(id);
            logger.info("删除角色 {}",role);
        }
    }

    /**
     * 根据id查找角色附带角色的权限列表
     * @return role
     */
    @Override
    public Role findRoleWithPermission(Integer id) {
        Role role = roleMapper.findByIdWithPermission(id);
        return role;
    }

    /**
     * 在编辑页面判断当前权限的复选框是否被checked
     * @param rolePermissionList 当前角色拥有的权限
     * @return 有顺序的map集合，如果被选择则value为true
     */
    @Override
    public Map<Permission, Boolean> permissionBooleanMap(List<Permission> rolePermissionList) {
        // 获得所有的权限列表
        List<Permission> permissionList = findAllPermission();

        // 获得有序的map集合
        Map<Permission,Boolean> resultMap = Maps.newLinkedHashMap();

        for(Permission permission : permissionList) {
            boolean flag = false;
            for(Permission rolePermission : rolePermissionList) {
                if(permission.getId().equals(rolePermission.getId())) {
                    flag = true;
                    break;
                }
            }
            resultMap.put(permission,flag);
        }
        return resultMap;
    }

    /**
     * 更新角色
     *
     * @param role 角色对象
     * @param permissionIds 角色拥有的新的权限id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void editRole(Role role, Integer[] permissionIds) {

        //将角色原有和权限的对应关系删除
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(role.getId());
        rolePermissionMapper.deleteByExample(rolePermissionExample);

        //重建角色和权限的对应关系
        for(Integer permissionId : permissionIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(role.getId());
            rolePermissionMapper.insert(rolePermission);
        }
        //修改角色对象
        roleMapper.updateByPrimaryKeySelective(role);

        logger.info("修改角色 {}",role);

    }

    /**
     * 获得多有的角色列表
     * @return
     */
    @Override
    public List<Role> findAllRoles() {
        RoleExample roleExample = new RoleExample();
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 查找id具有的角色列表
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleListByEmployeeId(Integer id) {
        return roleMapper.findListByEmployeeId(id);
    }


}
