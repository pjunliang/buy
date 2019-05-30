package com.pjl.springboot2;

import com.pjl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/index")
    public String index(Model model){
        List<User> list = new ArrayList<>();

        User u1 = new User();
        User u2 = new User();
        u1.setId(1);
        u1.setName("张三");
        u2.setId(2);
        u2.setName("李四");
        list.add(u1);
        list.add(u2);
        model.addAttribute("list",list);
        return "index";
    }
}
