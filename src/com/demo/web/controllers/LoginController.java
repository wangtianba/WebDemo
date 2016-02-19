package com.demo.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.web.models.AccountModel;
import com.demo.web.utils.MyBatis;
import com.demo.web.utils.User;

@Controller 
@RequestMapping(value = "/blog")
public class LoginController {
	   @RequestMapping(value="/login", method = {RequestMethod.GET})
	    public String loggingIn(HttpServletRequest request, Model model){
	        
	        model.addAttribute("accountmodel", new AccountModel());
	        return "login";
	    }

	    @RequestMapping(value="/login", method = {RequestMethod.POST})
	    public String loggingInResult(HttpServletRequest request, Model model, AccountModel accountModel){
	        
	        model.addAttribute("accountmodel", accountModel);
	        System.out.println(accountModel.getUsername());
	        String password = MyBatis.getUser(accountModel.getUsername()).getPassword();
	        if(accountModel.getPassword().equals(password)){
	        	return "loginSuccess";
	        }else {
				return "loginFail";
			}
	        
	    }
	    @RequestMapping(value="/register", method = {RequestMethod.GET})
	    public String register(HttpServletRequest request, Model model){
	        
	        model.addAttribute("accountmodel", new AccountModel());
	        return "register";
	    }
	    
	    @RequestMapping(value="/register", method = {RequestMethod.POST})
	    public String register(HttpServletRequest request, Model model, AccountModel accountModel){
	        User user = new User();
	        user.setName(accountModel.getUsername());
	        user.setPassword(accountModel.getPassword());
	        user.setPhone(accountModel.getPhone());
	        user.setInfo("123");
	        if(user.getType()==0){
	        	user.setType(1);
	        }
	        MyBatis.createUser(user);
	        model.addAttribute("accountmodel", accountModel);
	        return "registerSuccess";
	    }
}
