package com.yueqian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("index")
    public String index(){
        return "jerbel一个springboot测试";
    }
}
