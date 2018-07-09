package com.husky.persys.modalur.sys.vo;

import com.husky.persys.modalur.sys.entity.SysRole;

public class RolePermVO {
    private SysRole role;
    private int permId;
    private int[] permIds;

    public RolePermVO(){
        super();
    }

    public RolePermVO(SysRole role, int permId, int[] permIds) {
        this.role = role;
        this.permId = permId;
        this.permIds = permIds;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    public int[] getPermIds() {
        return permIds;
    }

    public void setPermIds(int[] permIds) {
        this.permIds = permIds;
    }
}
