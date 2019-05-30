package com.shop.controller;

import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegesiterController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/toregesiter")
    public String toregesiter(){
        return "regesiter";
    }

    @RequestMapping(value = "/regesiter")
    public String regesiterUser(Model model, User user){

        Integer row = userService.saveUser(user);
        if(row>0){
            return "redirect:/login";
        }
        model.addAttribute("error","注册失败");
        return "redirect:/login";

    }
}
