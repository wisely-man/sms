package com.demo.core.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if(!StringUtils.contains(url, "login") &&
                request.getSession().getAttribute("userInfo") == null){
            // 未登录跳转登录页面
            response.sendRedirect(request.getContextPath()+"/login/toLogin");
        }

        return true;
    }
}
