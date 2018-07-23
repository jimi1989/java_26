package com.kaishengit.controller.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----------------pre---------------");
        String uri = request.getRequestURI();

        if(uri.startsWith("/static")) {
            return true;
        }

        // 判断是否登录
        HttpSession session = request.getSession();
        if(session.getAttribute("curr_admin") == null) {
            response.sendRedirect("/login");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----------------post---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----------------after callback---------------");
    }
}
