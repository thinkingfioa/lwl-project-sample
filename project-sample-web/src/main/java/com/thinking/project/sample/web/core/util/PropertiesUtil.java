package com.thinking.project.sample.web.core.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author thinking_fioa
 * @createTime 2017/12/28
 * @description 支持用户配置属性
 */

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
    private static Map<String, Object> ctxPropertiesMap;

    /**
     * 继承覆写读取属性方法
     * @param beanFactoryToProcess
     * @param props
     * @throws BeansException
     */
    @Override
    public void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);

        ctxPropertiesMap = new HashMap<String, Object>();
        for(Object key : props.keySet()) {
            String keyString = key.toString();
            Object valueObject= props.get(keyString);
            ctxPropertiesMap.put(keyString, valueObject);
        }
    }

    /**
     * 获取属性
     * @param key 关键字
     * @return 如果未配置，返回null
     */
    public static Object getProperty(String key) {
        if(StringUtils.isEmpty(key)) {
            throw new NullPointerException("key is null");
        }

        return ctxPropertiesMap.get(key);
    }

    /**
     * 获取属性
     * @param key 关键字
     * @param defaultValue 缺省值
     * @return 属性未配置，返回缺省值 {@code defaultValue}
     */
    public static Object getProperty(String key, Object defaultValue) {
        if(StringUtils.isEmpty(key)) {
            throw new NullPointerException("key is null");
        }

        return ctxPropertiesMap.get(key) == null ? defaultValue: ctxPropertiesMap.get(key);
    }


    /**
     * 获取String类型的属性
     * @param key 关键字
     * @return 属性未配置，返回空串
     */
    public static String getStringProperty(String key) {

        Object value = getProperty(key);
        return value == null ? "": value.toString();
    }

    /**
     * 获取String类型的属性
     * @param key 关键字
     * @param defaultValue 缺省值
     * @return 属性未配置，返回缺省值 {@code defaultValue}
     */
    public static String getStringProperty(String key, String defaultValue) {

        Object value = getProperty(key);
        return value == null ? "": value.toString();
    }
}
