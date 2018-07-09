package com.husky.persys.config.shiro;

import com.husky.persys.common.filter.PSFormAuthenticationFilter;
import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.dao.SysPermMapper;
import com.husky.persys.modalur.sys.entity.SysPerm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //配置shiro的SecurityManager
    @Autowired
    SysPermMapper sysPermMapper;

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(perSysRealm());
        return securityManager;
    }

    //配置shiro的过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //修改过滤器的实现
        Map<String,Filter> filters = new LinkedHashMap<>();
        filters.put("authc",new PSFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);


//        Map<String,String> map = new LinkedHashMap<String,String>();
        //过滤器由上向下查找，一旦某个过滤器执行了，下面的过滤器将不再过滤
        //anon这个过滤器是表明任何用户（包括非认证用户）可访问资源
        //此处是静态权限
//        map.put("/static/**","anon");
//        map.put("/webjars/**","anon");
//        map.put("/**","authc");
        //动态权限

        Map<String,String> map = new LinkedHashMap<>();
        map.put("/webjars/**","anon");
        map.put("/images/*","anon");
        map.put("/js/**","anon");
        //从数据库中获取所有的权限信息
        int count = sysPermMapper.count();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStart(0);
        pageInfo.setSize(count);
        System.out.println(count);
        List<SysPerm> perms = sysPermMapper.findAll(pageInfo);
        System.out.println(perms);
        for(SysPerm sysPerm : perms){
            map.put(sysPerm.getUrl(),"perms["+sysPerm.getPerms()+"]");
        }
        map.put("/logout","logout");
        map.put("/**","authc");

        System.out.println(map);
        //声明登录界面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //声明登录成功的界面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //声明未认证界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //配置realm，以便实现认证和授权（实现login方法）
    @Bean
    public PermSysRealm perSysRealm(){
        return new PermSysRealm();
    }

    //配置支持shiro注解
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
