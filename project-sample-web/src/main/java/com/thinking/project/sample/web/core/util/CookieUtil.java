package com.thinking.project.sample.web.core.util;

import com.thinking.project.sample.web.controller.interceptor.CookieInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author thinking_fioa
 * @createTime 2017/12/28
 * @description 提供Cookie的缓存工具类
 */


public final class CookieUtil {

    // 缓存时间，单位/秒, 2H
    private static final int COOKIE_MAX_AGE = 60 * 60 *2;
    // 保存路径，根路径
    private static final String COOKIE_PATH = "/";

    /**
     * 存储
     * @param response
     * @param key Cookie关键字
     * @param value Cookie的值
     * @param ifRemember 是否缓存
     */
    public static void set(HttpServletResponse response, String key, String value, boolean ifRemember) {
        int age = ifRemember? COOKIE_MAX_AGE: -1;
        set(response, key, value, null, COOKIE_PATH, age, true);
    }

    /**
     * 提供给内部Cookie存储方法，暂定private
     * @param response
     * @param key Cookie关键字
     * @param value Cookie的值
     * @param domain 域名
     * @param path 存放路径
     * @param maxAge 最大缓存时间
     * @param isHttpOnly
     */
    private static void set(HttpServletResponse response, String key, String value, String domain,
                            String path, int maxAge, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);
        if(null != domain) {
            cookie.setDomain(domain);
        }
        cookie.setHttpOnly(isHttpOnly);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    /**
     * 获取存储的value
     * @param request
     * @param key 查询关键字
     * @return 若未找到，返回null. 调用方需要判空
     */
    public static String getValue(HttpServletRequest request, String key) {
        Cookie cookie = get(request, key);
        if(null != cookie) {
            return cookie.getValue();
        }
        return null;
    }

    private static Cookie get(HttpServletRequest request, String key) {
        Cookie [] arrCookie = request.getCookies();
        if(null != arrCookie && arrCookie.length > 0) {
            for(Cookie cookie : arrCookie) {
                if(cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }

        return null;
    }

    /**
     * 删除缓存
     * @param request
     * @param response
     * @param key
     */
    public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = get(request, key);
        if(null != cookie) {
            set(response, key, "", null, COOKIE_PATH, 0, true);
        }
    }
}
