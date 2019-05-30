package com.pjl.springboot;

import com.pjl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/index")
    public String index(Model model){
        System.out.println("已进入controller");
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userList",userList);
        return "index";
    }
}
