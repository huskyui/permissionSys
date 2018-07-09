package com.husky.persys.modalur.sys.dao;

import com.husky.persys.modalur.sys.vo.UserRoleVO;

public interface SysUserRoleMapper {
    void deleteCascadeInfo(UserRoleVO userRoleVO);
    void insertCascadeInfo(UserRoleVO userRoleVO);

}
