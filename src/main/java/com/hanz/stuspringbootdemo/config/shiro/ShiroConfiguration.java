package com.hanz.stuspringbootdemo.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//securityManager是shiro的第二大组件

@Configuration
public class ShiroConfiguration {
    //将自己的验证方式加入容器
    //需要修改，改成自己的验证器
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    //需要修改，各种情况下的跳转页面
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        //登出 ,加接口名，  logout权限验证不通过时，请求该接口，登录认证（用户名、密码）  key不可以变，value可以变
        map.put("/logout", "logout");
        //对所有用户认证,authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        map.put("/**", "authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/loginShiro/*/*");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/errorpage");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效,使用代理方式;所以需要开启代码支持;否则@RequiresRoles等注解无法生效
    //@RequiresRoles身份验证注解，（）后面填验证信息
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //回收器
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //通知代理器
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
    /**
     * 哈希密码比较器。在myShiroRealm中作用参数使用
     * 登陆时会比较用户输入的密码，跟数据库密码配合盐值salt解密后是否一致。
     * @return

     @Bean public HashedCredentialsMatcher hashedCredentialsMatcher(){
     HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
     hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用md5算法;
     hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5( md5(""));
     return hashedCredentialsMatcher;
     }
     */
}
