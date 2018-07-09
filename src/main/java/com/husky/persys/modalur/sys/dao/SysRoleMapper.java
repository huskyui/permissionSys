package com.husky.persys.modalur.sys.dao;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysRole;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SysRoleMapper {


    List<SysRole> findByUserId(int id);
    void delete(int id);
    void insert(SysRole role);
    void update(SysRole role);
    SysRole findById(int id);
    List<SysRole> findAll(PageInfo page);
    int count();

}
