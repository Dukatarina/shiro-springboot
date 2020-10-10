package com.xxx.demo.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager defaultSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultSecurityManager);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/add", "perms[user:add]");
        map.put("/user/update", "perms[user:update]");
        //设置登出
        map.put("/logout", "logout");
        map.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    @Bean
    public DefaultSecurityManager defaultSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
