package com.husky.persys.modalur.sys.dao;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysPerm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysPermMapper {

    List<SysPerm> findByRoleId(int id);
    void insert(SysPerm perm);
    void delete(int id);
    void update(SysPerm perm);
    SysPerm findById(int id);
    List<SysPerm> findAll(PageInfo page);
    int count();

}
