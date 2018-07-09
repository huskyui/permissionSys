package com.husky.persys.modalur.sys.service;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysRole;
import com.husky.persys.modalur.sys.vo.RolePermVO;

import java.util.List;

public interface SysRoleService {
    void addSysRole(RolePermVO vo);

    void deleteSysRole(int id);

    void updateSysRole(RolePermVO vo);

    SysRole getSysRoleInfo(int id);

    List<SysRole> getAllSysRoleInfo(PageInfo pageInfo);

    int count();

}
