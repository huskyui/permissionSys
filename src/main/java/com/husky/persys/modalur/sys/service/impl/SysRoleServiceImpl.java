package com.husky.persys.modalur.sys.service.impl;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.dao.SysPermMapper;
import com.husky.persys.modalur.sys.dao.SysRoleMapper;
import com.husky.persys.modalur.sys.dao.SysRolePermMapper;
import com.husky.persys.modalur.sys.dao.SysUserRoleMapper;
import com.husky.persys.modalur.sys.entity.SysRole;
import com.husky.persys.modalur.sys.entity.SysUser;
import com.husky.persys.modalur.sys.service.SysRoleService;
import com.husky.persys.modalur.sys.vo.RolePermVO;
import com.husky.persys.modalur.sys.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermMapper sysRolePermMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    //添加role数据时会添加相应权限信息
    @Transactional
    @Override
    public void addSysRole(RolePermVO vo) {
        sysRoleMapper.insert(vo.getRole());
        for(int permId:vo.getPermIds()){
            sysRolePermMapper.insertCascadeInfo(new RolePermVO(vo.getRole(),permId,null));
        }
    }

    @Transactional
    @Override
    public void deleteSysRole(int id) {
        //先删除别的表中的foregin key是role id，最后删除role表中的数据
        SysRole role = new SysRole();
        role.setRoleId(id);
        sysRolePermMapper.deleteCascadeInfo(new RolePermVO(role,-1,null));
        SysUser user = new SysUser();
        user.setUserId(-1);
        sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(user,id,null));
        sysRoleMapper.delete(id);
    }

    //更新role数据时，可能更新对应的权限
    @Transactional
    @Override
    public void updateSysRole(RolePermVO vo) {
        sysRoleMapper.update(vo.getRole());
        //删除原有的权限
        sysRolePermMapper.deleteCascadeInfo(new RolePermVO(vo.getRole(),-1,null));
        for(int permId:vo.getPermIds()){
            sysRolePermMapper.insertCascadeInfo(new RolePermVO(vo.getRole(),permId,null));
        }
    }

    @Override
    public SysRole getSysRoleInfo(int id) {
        return sysRoleMapper.findById(id);
    }

    @Override
    public List<SysRole> getAllSysRoleInfo(PageInfo pageInfo) {
        return sysRoleMapper.findAll(pageInfo);
    }

    @Override
    public int count() {
        return sysRoleMapper.count();
    }
}
