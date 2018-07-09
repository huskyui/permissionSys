package com.husky.persys.modalur.sys.service;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysPerm;

import java.util.List;

public interface SysPermService {

    void addSysPerm(SysPerm perm);

    void deleteSysPerm(int id);

    void updateSysPerm(SysPerm perm);

    SysPerm getSysPermInfo(int id);

    List<SysPerm> getAllSysPermInfo(PageInfo pageInfo);

    int count();



}
