package com.pjl.Controller;

import com.pjl.pojo.User;
import com.pjl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/inputPage")
    public String inputPage(){
        System.out.println("进入inputPage的controller");
        return "inputPage";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(User user){
        userService.saveUser(user);
        return "ok";
    }

    @RequestMapping(value = "/userList")
    public String userList(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "userList";
    }

    @RequestMapping(value = "/updatePage")
    public String updatePage(Model model,Integer id){
        System.out.println("id"+id);
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "updatePage";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/userList";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUserById(id);
        return "redirect:/userList";
    }
}
