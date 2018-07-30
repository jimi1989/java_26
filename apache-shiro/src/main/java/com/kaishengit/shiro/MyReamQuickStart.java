package com.kaishengit.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jinjianghao
 * @date 2018/7/30
 */
public class MyReamQuickStart {
    private static Logger logger = LoggerFactory.getLogger(MyReamQuickStart.class);
    public static void main(String[] args) {

        // 1.通过IniSecurityManagerFactory来获取SecurityManager安全管理器
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:my-realm.ini");
        SecurityManager securityManager = factory.getInstance();

        // 2.设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 3.通过SecurityUtils的getSubject()获得subject对象（主体账号）
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()) {
            // 没有通过认证，则根据用户名密码进行登录
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123123");
            // 5.通过login方法登录
            try {
                subject.login(usernamePasswordToken);
                System.out.println("isAuthenticated:" + subject.isAuthenticated());

                // subject.getPrincipal()方法获得当前登录账号的用户名（默认）
                logger.info("{} login success", subject.getPrincipal());
            } catch (UnknownAccountException e) {
                logger.info("用户名或者密码错误");
            } catch (IncorrectCredentialsException e) {
                logger.info("密码错误");
            } catch (LockedAccountException e) {
                logger.info("账户被锁定");
            } catch (AuthenticationException ae) {
                logger.info("认证失败");
            }
        }
    }
}
