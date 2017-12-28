package com.thinking.project.sample.web.core.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author thinking_fioa
 * @createTime 2017/12/28
 * @description PropertiesUtil测试
 */

@WebAppConfiguration(value = "src/main/webapp")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class PropertiesUtilTest {

    @Test
    public void accessProperties() throws Exception {
        System.out.println(PropertiesUtil.getProperty("project.sample.web.property.key"));
    }
}
