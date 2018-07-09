package com.husky.persys.modalur.sys.controller;


import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysUser;
import com.husky.persys.modalur.sys.service.SysUserService;
import com.husky.persys.modalur.sys.vo.UserRoleVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/addSysUser")
    public String addSysUser(UserRoleVO vo){
        sysUserService.addSysUser(vo);
        return "redirect:sysUserList";//此处，其实是通过controller跳转到/sysUserList
    }

    @RequestMapping("/deleteSysUser")
    public String deleteSysUser(int id){
        sysUserService.deleteSysUser(id);
        return "redirect:sysUserList";
    }

    @RequestMapping("/updateSysUser")
    public String updateSysUser(UserRoleVO vo){
        sysUserService.updateSysUser(vo);
        return "redirect:sysUserList";
    }

    @RequestMapping("/sysUserInfo")
    public @ResponseBody SysUser getSysUserInfo(int id){
        SysUser sysUser = sysUserService.getSysUserInfo(id);
        return sysUser;
    }

    @RequiresPermissions("resource:view")
    @RequestMapping("/sysUserList")
    public String getAllSysUserInfo(PageInfo pageInfo, Model model){
        if(pageInfo.getCurrentPage()==0){
            pageInfo.setCurrentPage(1);
        }
        pageInfo.setSize(10);
        pageInfo.setTotalResult(sysUserService.count());
        System.out.println(pageInfo);

        List<SysUser> sysUsers = sysUserService.getAllSysUserInfo(pageInfo);
        model.addAttribute("sysUserList",sysUsers);
        model.addAttribute("page",pageInfo);
        System.out.println(sysUsers);
        return "/sys/sysUserList";
    }




}
