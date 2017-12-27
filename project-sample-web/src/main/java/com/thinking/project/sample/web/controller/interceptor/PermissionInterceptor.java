package com.thinking.project.sample.web.controller.interceptor;

import com.thinking.projectname.common.annotation.PermissionLimit;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author thinking_fioa
 * @createTime 2017/12/27
 * @description 权限拦截
 */


public class PermissionInterceptor extends HandlerInterceptorAdapter{

    public static boolean ifLogin(HttpServletRequest request) {
        //todo:: 提供登录判断逻辑
        return true;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }

        if (!ifLogin(request)) {
            HandlerMethod method = (HandlerMethod)handler;
            PermissionLimit permission = method.getMethodAnnotation(PermissionLimit.class);
            if (permission == null || permission.limit()) {
                response.sendRedirect(request.getContextPath() + "/toLogin");
                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

}
