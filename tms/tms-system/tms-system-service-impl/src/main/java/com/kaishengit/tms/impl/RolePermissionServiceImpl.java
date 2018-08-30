package com.kaishengit.tms.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.mapper.PermissionMapper;
import com.kaishengit.tms.mapper.RolesMapper;
import com.kaishengit.tms.mapper.RolesPermissionMapper;
import com.kaishengit.tms.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色和权限的业务类
 * @author jinjianghao
 */
@Service(version = "1.0",timeout = 5000)
public class RolePermissionServiceImpl implements RolePermissionService {

    public static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private RolesPermissionMapper rolesPermissionMapper;
    @Autowired
    private AccountRolesMapper accountRolesMapper;
    /**
     * 添加权限
     *
     * @param permission
     */
    @Override
    public void savePermission(Permission permission) {
        permission.setCreateTime(new Date());
        permissionMapper.insertSelective(permission);
        logger.info("添加权限 {}",permission);
    }

    /**
     * 根据权限类型查询权限列表
     *
     * @param permissionType 权限类型 菜单|按钮
     * @return 对应的权限列表
     */
    @Override
    public List<Permission> findPermissionByPermissionType(String permissionType) {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(permissionType);
        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 查询所有的权限
     *
     * @return
     */
    @Override
    public List<Permission> findAllPermission() {
        PermissionExample permissionExample = new PermissionExample();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> resultList = new ArrayList<>();
        treeList(permissionList,resultList,0);
        return resultList;
    }

    /**
     * 新增角色
     *
     * @param roles        角色对象
     * @param permissionId 角色对应的权限ID列表
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveRoles(Roles roles, Integer[] permissionId) {
        //保存角色
        roles.setCreateTime(new Date());
        rolesMapper.insertSelective(roles);
        //保存角色和权限的关系
        if(permissionId != null) {
            for (Integer perId : permissionId) {
                RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
                rolesPermissionKey.setPermissionId(perId);
                rolesPermissionKey.setRolesId(roles.getId());

                rolesPermissionMapper.insert(rolesPermissionKey);
            }
        }
        logger.info("保存角色 {}",roles);
    }

    /**
     * 根据权限ID删除权限
     *
     * @param id
     * @throws ServiceException 删除失败抛出此异常，例如权限已经被角色使用
     */
    @Override
    public void delPermissionById(Integer id) throws ServiceException {
        //查询该权限是否有子节点
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andParentIdEqualTo(id);

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        if(permissionList != null && !permissionList.isEmpty()) {
            throw new ServiceException("该权限下有子节点，删除失败");
        }

        //查询权限是否被角色使用
        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andPermissionIdEqualTo(id);

        List<RolesPermissionKey> rolesPermissionKeyList = rolesPermissionMapper.selectByExample(rolesPermissionExample);
        if(rolesPermissionKeyList != null && !rolesPermissionKeyList.isEmpty()) {
            throw new ServiceException("该权限被角色引用，删除失败");
        }
        //如果没有被使用，则可以直接删除
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        permissionMapper.deleteByPrimaryKey(id);
        logger.info("删除权限 {}",permission);
    }

    /**
     * 查询所有的角色并加载角色拥有的权限列表
     *
     * @return
     */
    @Override
    public List<Roles> findAllRolesWithPermission() {
        return rolesMapper.findAllWithPermission();
    }

    /**
     * 根据角色主键删除角色
     *
     * @param id
     * @throws ServiceException
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delRolesById(Integer id) throws ServiceException {
        //查询是否被账号引用，如果引用则不能删除
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andRolesIdEqualTo(id);

        List<AccountRolesKey> accountRolesKeys = accountRolesMapper.selectByExample(accountRolesExample);
        if(accountRolesKeys != null && !accountRolesKeys.isEmpty()) {
            throw new ServiceException("该角色被账号引用，删除失败");
        }
        //删除角色和权限的关系记录
        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andRolesIdEqualTo(id);

        rolesPermissionMapper.deleteByExample(rolesPermissionExample);
        //删除角色
        Roles roles = rolesMapper.selectByPrimaryKey(id);
        rolesMapper.deleteByPrimaryKey(id);

        logger.info("删除角色 {}",roles);
    }

    /**
     * 根据角色ID查询角色对象及其拥有的权限
     *
     * @param id
     * @return
     */
    @Override
    public Roles findRolesWithPermissionById(Integer id) {
        return rolesMapper.findByIdWithPermission(id);
    }

    /**
     * 修改角色对象
     *
     * @param roles        角色对象
     * @param permissionId 角色拥有的新权限ID数组
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateRoles(Roles roles, Integer[] permissionId) {
        //将角色原有和权限的对应关系删除
        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andRolesIdEqualTo(roles.getId());

        rolesPermissionMapper.deleteByExample(rolesPermissionExample);
        //重建角色和权限的对应关系
        for(Integer perId : permissionId) {
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setRolesId(roles.getId());
            rolesPermissionKey.setPermissionId(perId);
            rolesPermissionMapper.insert(rolesPermissionKey);
        }
        //修改角色对象
        rolesMapper.updateByPrimaryKeySelective(roles);

        logger.info("修改角色 {}",roles);
    }

    /**
     * 查询所有的角色
     */
    @Override
    public List<Roles> findAllRoles() {
        RolesExample rolesExample = new RolesExample();
        return rolesMapper.selectByExample(rolesExample);
    }

    /**
     * 根据账号ID查询拥有的角色集合
     *
     * @param id 账号ID
     * @return
     */
    @Override
    public List<Roles> findRolesByAccountId(Integer id) {
        return rolesMapper.findRolesByAccountId(id);
    }

    /**
     * 根据角色ID查询所有的对应的权限
     *
     * @param rolesId 角色ID
     * @return
     */
    @Override
    public List<Permission> findAllPermissionByRolesId(Integer rolesId) {
        return permissionMapper.findAllByRolesId(rolesId);
    }

    /**
     * 将查询数据库的角色列表转换为树形集合结果
     * @param sourceList 数据库查询出的集合
     * @param endList 转换结束的结果集合
     * @param parentId 父ID
     */
    private void treeList(List<Permission> sourceList, List<Permission> endList, int parentId) {
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(sourceList, permission -> permission.getParentId().equals(parentId)));

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

    @Override
    public void editPermission(Permission permission) {
        // 设置更新时间
        permission.setUpdateTime(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);
        logger.info("更新权限 {}",permission);
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

}
