package com.husky.persys.modalur.sys.controller;


import com.husky.persys.common.utils.PageInfo;
import com.husky.persys.modalur.sys.entity.SysPerm;
import com.husky.persys.modalur.sys.service.ShiroService;
import com.husky.persys.modalur.sys.service.SysPermService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SysPermController {
    @Resource
    private SysPermService sysPermService;

    @Resource
    private ShiroService shiroService;

    @RequestMapping("/addSysPerm")
    public String addSysPerm(SysPerm sysPerm){
        sysPermService.addSysPerm(sysPerm);
        shiroService.updatePermissions();
        return "redirect:sysPermList";
    }

    @RequestMapping("/deleteSysPerm")
    public String deleteSysPerm(int id){
        sysPermService.deleteSysPerm(id);
        shiroService.updatePermissions();
        return "redirect:sysPermList";
    }

    @RequestMapping("/updateSysPerm")
    @RequiresPermissions("perm:update")
    public String updateSysPerm(SysPerm sysPerm){
        sysPermService.updateSysPerm(sysPerm);
        shiroService.updatePermissions();
        return "redirect:sysPermList";
    }

    @RequestMapping("/sysPermInfo")
    public @ResponseBody SysPerm getSysPermInfo(int id){
        SysPerm sysPerm = sysPermService.getSysPermInfo(id);
        return sysPerm;
    }

    @RequestMapping("/sysPermList")
    public String getAllSysPermInfo(PageInfo pageInfo,Model model){
        List<SysPerm> sysPermList = sysPermService.getAllSysPermInfo(pageInfo);
        model.addAttribute("sysPermList",sysPermList);
        return "/sysPermList";
    }

    @RequestMapping("/sysPermJson")
    public @ResponseBody List<SysPerm> getAllSysPermInfoByJson(PageInfo pageInfo){

        pageInfo.setSize(10);
        System.out.println("pageInfo:"+pageInfo);
        List<SysPerm> sysPerms = sysPermService.getAllSysPermInfo(pageInfo);
        System.out.println(sysPerms);
        return sysPerms;
    }
}
