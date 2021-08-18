//package com.how2java.springboot.config;
//
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
//import com.how2java.springboot.Realm.MyShiroRealm;
//import com.how2java.springboot.pojo.Permission;
//import com.how2java.springboot.service.PermissionService;
//import com.how2java.springboot.service.PersonService;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@Configuration
//public class ShiroConfig {
//    @Autowired
//    PermissionService permissionService;
///*过滤工厂，可以配置过滤链接*/
//
//    @Bean
//    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
//        System.out.println("过滤不明链接。。。");
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //拦截器.
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // 配置不会被拦截的链接 顺序判断
//        /*Map中key是url，value是shiro的名词
//        * anon:代表匿名访问，也就是说不需要权限就可访问
//        * authc:代表身份验证后即可访问
//        * perms[url]:代表用户需要拥有url的权限才允许访问。
//        * 注意以下是有先后顺序的
//        * */
//        filterChainDefinitionMap.put("/swagger**/**", "anon");
//        filterChainDefinitionMap.put("/swagger-ui.html**","anon");
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/HeaderConfig/**","anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/element/**", "anon");
//        filterChainDefinitionMap.put("/bootstrap/**", "anon");
//        filterChainDefinitionMap.put("/druid/**", "anon");
//
//      /*  filterChainDefinitionMap.put("/main","authc");
//        filterChainDefinitionMap.put("/login","anon");*/
//        filterChainDefinitionMap.put("/foreLogin", "anon");
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout", "logout");
//
//        /*perms[url]:代表用户需要拥有url的权限才允许访问。*/
//        List<Permission> pList =permissionService.getAllPermission();
//        pList.forEach(per -> {
//            filterChainDefinitionMap.put("/"+per.getUrl(),"perms["+per.getUrl()+"]");
//        });
//
//        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
//        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/**", "authc");
//
//        // 设置登录界面对应的url
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        // 设置登录成功后的主界面的url
//        shiroFilterFactoryBean.setSuccessUrl("/main");
//        //设置未授权界面的url;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/errorPage");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
///*自定义的Realm
//* 其作用是有两个，一个做身份验证。即查询数据库中是否有该用户的存在
//* 一个是授权，即该用户是否拥有某个菜单或者按钮的权限
//* */
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        /*realm中开启加密*/
//        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myShiroRealm;
//    }
///*shiro核心，安全管理器--securityManager*/
//    @Bean
//    public DefaultWebSecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//    }
//
//    /*用于thymeleaf模板使用shiro标签*/
//    @Bean
//    public ShiroDialect getShiroDialect(){
//        return new ShiroDialect();
//    }
//
//    /**
//     *  开启shiro aop注解支持.即可使用@RequirePermission("")方式
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager( securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
///*设置加密方式和加密次数*/
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashIterations(1024);
//        return hashedCredentialsMatcher;
//    }
//}