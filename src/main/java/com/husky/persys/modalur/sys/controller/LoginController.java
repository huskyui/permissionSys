package com.husky.persys.modalur.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("/login");
        return "/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/resource")
    @RequiresPermissions("resource:view")
    public String show(){
        System.out.println("/resource");
        return "/resource";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "/hello";
    }

    @RequestMapping("/addPermJsp")
    public String addPerm(){
        return "/addPerm";
    }

}
