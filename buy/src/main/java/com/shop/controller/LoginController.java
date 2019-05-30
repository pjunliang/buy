package com.shop.controller;

import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

	@Resource
	UserService userService;

	@RequestMapping(value = "/login")
	public String login(){

		return "login";
	}

	@RequestMapping(value = "/doLogin")
	public String doLogin(String username,String userPassword,
						  String valideCode,Model model,HttpSession session){
		String vc = (String) session.getAttribute("vrifyCode");
		if(!(vc.equals(valideCode))){
			model.addAttribute("errorMsg","你输入的验证码有误");
			return "login";
		}
		List<User> users = userService.findUserByName(username, userPassword);
		if(users !=null && users.size()>0){
			User user = users.get(0);
			session.setAttribute("user",user);
			return "redirect:/index";
		}
		model.addAttribute("errorMsg","你输入用户名或者密码有误");
		return "login";

	}
}
