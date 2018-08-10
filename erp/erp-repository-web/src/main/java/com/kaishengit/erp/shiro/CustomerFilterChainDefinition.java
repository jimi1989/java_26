package erp.shiro;

import com.kaishengit.erp.entity.Permission;
import com.kaishengit.erp.service.RolePermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/31
 */
public class CustomerFilterChainDefinition {

    @Autowired
    private RolePermissionService rolePermissionService;

    private String filterChainDefinitions;

    private AbstractShiroFilter shiroFilter;

    @PostConstruct
    public synchronized void init() {
        System.out.println("------------权限初始化中-----------");
        // 清空原有权限
        getFilterChainManager().getFilterChains().clear();
        // 加载新的权限
        load();
    }

    public synchronized void updatePermission() {
        System.out.println("------------权限初更新中-----------");
        // 清空原有权限
        getFilterChainManager().getFilterChains().clear();
        // 加载新的权限
        load();
    }

    public synchronized void load(){
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        List<Permission> permissionList = rolePermissionService.findAllPermission();
        for(Permission permission : permissionList) {
            // /manage/employee/new = perms[employee:add]
            section.put(permission.getUrl(), "perms[" + permission.getPermissionCode() + "]");
        }
        section.put("/**","user");

        DefaultFilterChainManager defaultFilterChainManager = getFilterChainManager();
        for(Ini.Section.Entry<String,String> entry : section.entrySet() ) {
            defaultFilterChainManager.createChain(entry.getKey(), entry.getValue());
        }

    }

    public DefaultFilterChainManager getFilterChainManager() {
        PathMatchingFilterChainResolver pathMatchingFilterChainResolver = (PathMatchingFilterChainResolver) this.shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) pathMatchingFilterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }
}
