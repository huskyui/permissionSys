package com.husky.persys.modalur.sys.service;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysUser;
import com.husky.persys.modalur.sys.vo.UserRoleVO;

import java.util.List;

public interface SysUserService {
    public SysUser findByName(String name);

    public void addSysUser(UserRoleVO vo);

    public void deleteSysUser(int id);

    public void updateSysUser(UserRoleVO vo);

    public SysUser getSysUserInfo(int id);

    public List<SysUser> getAllSysUserInfo(PageInfo pageInfo);

    int count();


}
