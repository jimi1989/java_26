package com.kaishengit.tms.config;

import com.kaishengit.tms.shiro.CustomerFilterChainDefinition;
import com.kaishengit.tms.shiro.ShiroRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author jinjianghao
 * @date 2018/8/27
 */
@Configuration
public class JavaConfig {


    @Bean
    public Realm realm() {
        return new ShiroRealm();
    }

    @Bean
    public CustomerFilterChainDefinition customerFilterChainDefinition(ShiroFilterFactoryBean shiroFilterFactoryBean) throws Exception {
        CustomerFilterChainDefinition customerFilterChainDefinition = new CustomerFilterChainDefinition();
        customerFilterChainDefinition.setShiroFilter((AbstractShiroFilter) shiroFilterFactoryBean.getObject());

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("/favicon.ico","anon");
        map.put("/bootstrap/**","anon");
        map.put("/dist/**","anon");
        map.put("/plugins/**","anon");
        map.put("/js/**","anon");
        map.put("/logout","logout");

        customerFilterChainDefinition.setFilterChainDefinitions(map);
        return customerFilterChainDefinition;
    }


}
