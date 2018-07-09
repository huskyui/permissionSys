package com.husky.persys.modalur.sys.service.impl;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.dao.SysUserMapper;
import com.husky.persys.modalur.sys.dao.SysUserRoleMapper;
import com.husky.persys.modalur.sys.entity.SysUser;
import com.husky.persys.modalur.sys.service.SysUserService;
import com.husky.persys.modalur.sys.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;



    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }


    //此处添加事务管理，防止并发事务导致的问题
    @Transactional
    @Override
    public void addSysUser(UserRoleVO vo) {
        sysUserMapper.insert(vo.getUser());
        if(vo.getRoleIds()!=null) {
            for (int roleId : vo.getRoleIds()) {
                sysUserRoleMapper.insertCascadeInfo(new UserRoleVO(vo.getUser(), roleId, null));
            }
        }
    }

    @Transactional
    @Override
    public void deleteSysUser(int id) {
        sysUserMapper.delete(id);
        SysUser user = new SysUser();
        user.setUserId(id);
        sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(user,-1,null));
    }

    @Transactional
    @Override
    public void updateSysUser(UserRoleVO vo) {
        sysUserMapper.update(vo.getUser());
        sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(vo.getUser(),-1,null));
        if(vo.getRoleIds()!=null){
            for(int roleId:vo.getRoleIds()){
                sysUserRoleMapper.insertCascadeInfo(new UserRoleVO(vo.getUser(),roleId,null));
            }
        }
    }

    @Override
    public SysUser getSysUserInfo(int id) {
        return sysUserMapper.findById(id);
    }

    @Override
    public List<SysUser> getAllSysUserInfo(PageInfo pageInfo) {
        return sysUserMapper.findAll(pageInfo);
    }

    @Override
    public int count() {
        return sysUserMapper.count();
    }
}
