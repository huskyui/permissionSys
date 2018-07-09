package com.husky.persys.modalur.sys.service.impl;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.dao.SysPermMapper;
import com.husky.persys.modalur.sys.dao.SysRolePermMapper;
import com.husky.persys.modalur.sys.entity.SysPerm;
import com.husky.persys.modalur.sys.entity.SysRole;
import com.husky.persys.modalur.sys.service.SysPermService;
import com.husky.persys.modalur.sys.vo.RolePermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SysPermServiceImpl implements SysPermService {

    @Autowired
    private SysPermMapper sysPermMapper;
    @Autowired
    private SysRolePermMapper sysRolePermMapper;

    @Transactional
    @Override
    public void addSysPerm(SysPerm perm) {
        sysPermMapper.insert(perm);
    }


    @Transactional
    @Override
    public void deleteSysPerm(int id) {
        sysPermMapper.delete(id);
        SysRole role = new SysRole();
        role.setRoleId(-1);
        sysRolePermMapper.deleteCascadeInfo(new RolePermVO(role,id,null));
    }

    @Transactional
    @Override
    public void updateSysPerm(SysPerm perm) {
        sysPermMapper.update(perm);
    }

    @Override
    public SysPerm getSysPermInfo(int id) {
        return sysPermMapper.findById(id);
    }

    @Override
    public List<SysPerm> getAllSysPermInfo(PageInfo pageInfo) {
        return sysPermMapper.findAll(pageInfo);
    }

    @Override
    public int count() {
        return sysPermMapper.count();
    }
}
