package com.husky.persys.modalur.sys.controller;

import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysRole;
import com.husky.persys.modalur.sys.service.SysRoleService;
import com.husky.persys.modalur.sys.vo.RolePermVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("/addSysRole")
    public String addSysRole(RolePermVO vo){
        sysRoleService.addSysRole(vo);
        return "redirect:sysRoleList";
    }

    @RequestMapping("/deleteSysRole")
    public String deleteSysRole(int id){
        sysRoleService.deleteSysRole(id);
        return "redirect:sysRoleList";
    }

    @RequestMapping("/updateSysRole")
    public String updateSysRole(RolePermVO vo){
        sysRoleService.updateSysRole(vo);
        return "redirect:sysRoleList";
    }

    @RequestMapping("/sysRoleInfo")
    public @ResponseBody SysRole getSysRoleInfo(int id){
        SysRole sysRole = sysRoleService.getSysRoleInfo(id);
        return  sysRole;
    }

    @RequestMapping("/sysRoleJson")
    public @ResponseBody List<SysRole> getAllSysRoleJson(PageInfo pageInfo){
        if(pageInfo.getCurrentPage()==0){
            pageInfo.setCurrentPage(1);
        }
        pageInfo.setSize(10);
        pageInfo.setTotalResult(sysRoleService.count());
        List<SysRole> sysRoles = sysRoleService.getAllSysRoleInfo(pageInfo);
        return sysRoles;
    }

    @RequestMapping("/sysRoleList")
    public String getAllSysRoleInfo(PageInfo pageInfo, Model model){
        if(pageInfo.getCurrentPage()==0){
            pageInfo.setCurrentPage(1);
        }
        pageInfo.setSize(10);
        pageInfo.setTotalResult(sysRoleService.count());
        System.out.println(pageInfo);
        List<SysRole> sysRoleList = sysRoleService.getAllSysRoleInfo(pageInfo);
        model.addAttribute("sysRoleList",sysRoleList);
        model.addAttribute("page",pageInfo);
        System.out.println(sysRoleList);
        return "/sys/sysRoleList";
    }



}
