package com.kaishengit.erp.shiro;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.service.RolePermissionService;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/31
 */
public class CustomerFilterChainDefinition implements FactoryBean<Ini.Section> {

    @Autowired
    private RolePermissionService rolePermissionService;

    private String filterChainDefinitions;



    @Override
    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        List<Permission> permissionList = rolePermissionService.findAllPermission();
        for(Permission permission : permissionList) {
            // /manage/employee/new = perms[employee:add]
            section.put(permission.getUrl(), "perms[" + permission.getPermissionCode() + "]");
        }
        section.put("/**","user");

        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
