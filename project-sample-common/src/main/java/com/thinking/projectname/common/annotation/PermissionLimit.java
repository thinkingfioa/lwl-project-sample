package com.thinking.projectname.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author thinking_fioa
 * @createTime 2017/12/27
 * @description 权限控制
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionLimit {

    /**
     * 登录拦截（默认为true)
     * @return
     */
    boolean limit() default true;
}
