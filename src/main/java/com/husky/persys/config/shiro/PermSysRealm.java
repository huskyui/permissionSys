package com.husky.persys.config.shiro;

import com.husky.persys.modalur.sys.entity.SysPerm;
import com.husky.persys.modalur.sys.entity.SysRole;
import com.husky.persys.modalur.sys.entity.SysUser;
import com.husky.persys.modalur.sys.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class PermSysRealm extends AuthorizingRealm {
    @Resource
    private SysUserService sysUserService;

    //实现授权
    //该处，实现对该用户的role和permission在数据库查询，并将role和permission放入info，
    //然后和filtermap进行对比，实现权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();

        System.out.println("user :"+sysUser);
        for(SysRole role:sysUser.getSysRoles()){
            info.addRole(role.getRoleName());
            for(SysPerm perm:role.getSysPerms()){
                info.addStringPermission(perm.getPerms());
            }
        }
        return info;
    }
    //实现认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo");
        UsernamePasswordToken uptoken = (UsernamePasswordToken)authenticationToken;
        SysUser sysUser = sysUserService.findByName(uptoken.getUsername());
        if(sysUser==null){
            return null;
        }
        String principal = sysUser.getUsername();//用户名
        String credentials = sysUser.getPassword();
        String realmName = getName();
        System.out.println("principal: "+principal+" credentials: "+credentials+" realmName: "+getName());
        //认证信息就是用户在数据库中的数据，参数中的token就是用户输入的信息，就是比较这个两个对象
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser,credentials,realmName);
        return info;
    }
}
