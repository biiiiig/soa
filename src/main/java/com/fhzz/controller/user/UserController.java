package com.fhzz.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fhzz.model.User;
import com.fhzz.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
    //重载
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
         return "/user/login";
    }
    
	@RequestMapping(value="login" , method= RequestMethod.POST)
	public String login(@RequestParam(value="userName") String userName,
						@RequestParam(value="passWord") String passWord,
						HttpSession session){
		 User loginUser = userService.checkLogin(userName);
		 session.setAttribute("loginUser", loginUser);
	     return "redirect:/user/success";
		
	}
	
	
    @RequestMapping(value = "success")
	public String success(Model model,HttpSession session){
    	model.addAttribute("user",session.getAttribute("loginUser"));
		return "/main/success";
    }
    @RequestMapping(value = "logout")
    public String logout(Model model,HttpSession session){
    	session.removeAttribute("loginUser");
		return "redirect:/user/login";
    }

}
