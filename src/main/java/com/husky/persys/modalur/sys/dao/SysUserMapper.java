package com.husky.persys.modalur.sys.dao;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SysUserMapper {

    SysUser findByName(String name);

    void delete(int id);

    void insert(SysUser user);

    void update(SysUser user);

    SysUser findById(int id);

    List<SysUser> findAll(PageInfo page);

    int count();
}
