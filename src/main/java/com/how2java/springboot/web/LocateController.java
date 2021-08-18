package com.how2java.springboot.web;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LocateController {


    @RequestMapping("/listPerson")
    public ModelAndView listPerson(){
        ModelAndView m = new ModelAndView("listPerson");
        return m;
    }

    /*主界面*/
    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView m = new ModelAndView("mainPage");
        return m;
    }
/*登录界面*/
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView m = new ModelAndView("login");
        return m;
    }
    @RequestMapping("/errorPage")
    public ModelAndView error(){
        ModelAndView m = new ModelAndView("unAuth");
        return m;
    }
    @RequestMapping("/listPermission")
    public ModelAndView listPermission(){
        ModelAndView m = new ModelAndView("Authority/listPermission");
        return m;
    }

    @RequestMapping("/listRole")
    public ModelAndView listRole(){
        ModelAndView m = new ModelAndView("Authority/listRole");
        return m;
    }

    @RequestMapping("/downLoad")
    public ModelAndView downLoadPage(){
        ModelAndView m = new ModelAndView("DownLoadFile/downLoadPage");
        return m;
    }
}
