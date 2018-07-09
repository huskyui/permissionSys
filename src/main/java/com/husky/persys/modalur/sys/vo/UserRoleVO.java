package com.husky.persys.modalur.sys.vo;

import com.husky.persys.modalur.sys.entity.SysUser;

public class UserRoleVO {
    private SysUser user;
    private int roleId;
    private int[] roleIds;

    public UserRoleVO(){
        super();
    }

    public UserRoleVO(SysUser user, int roleId, int[] roleIds) {
        this.user = user;
        this.roleId = roleId;
        this.roleIds = roleIds;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }
}
