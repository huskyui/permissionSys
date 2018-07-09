package com.husky.persys.modalur.sys.dao;

import com.husky.persys.modalur.sys.vo.RolePermVO;

public interface SysRolePermMapper {
    void deleteCascadeInfo(RolePermVO rolePermVO);
    void insertCascadeInfo(RolePermVO rolePermVO);

}
