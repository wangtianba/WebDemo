package com.demo.web.controllers;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.web.models.AccountModel;
import com.demo.web.utils.Login_status;
import com.demo.web.utils.MyBatis;
import com.demo.web.utils.User;
import com.demo.web.utils.Constant;
import com.mysql.jdbc.StringUtils;

@Controller 
@RequestMapping(value = "/blog")
public class LoginController {
	   @RequestMapping(value="/login", method = {RequestMethod.GET})
	    public String loggingIn(HttpServletRequest request,HttpServletResponse response, Model model){
	        AccountModel accountModel = new AccountModel();
	        model.addAttribute("accountmodel", accountModel);
	        Boolean isLoggin = checkLogginStatus(request, response);//后期检查登录状态放到缓存中
	        System.out.println(isLoggin);
	        if(isLoggin){
	        	//拼装用户数据
		        Login_status login_status = MyBatis.getLogin_status(getCookie(request, Constant.LOGIN_COOKIE_KEY));
		        User userinfo = MyBatis.getUserById(login_status.getUser_id());
		        accountModel.setUsername(userinfo.getName());
		        System.out.println(userinfo.getName()+" 111 "+login_status.getUser_id());
		        accountModel.setPhone(userinfo.getNumber());
	        	return "blog page";
	        }
	        return "login";
	    }

	    @RequestMapping(value="/login", method = {RequestMethod.POST})
	    public String loggingInResult(HttpServletRequest request,HttpServletResponse response, Model model, AccountModel accountModel){
	        model.addAttribute("accountmodel", accountModel);
	        System.out.println(accountModel.getUsername());
	        User user = MyBatis.getUserByName(accountModel.getUsername());
	        if(user != null && accountModel.getPassword().equals(user.getPassword())){
	        	accountModel.setPhone(user.getNumber());
	        	setLoginStatus(response, accountModel);
	        	return "loginSuccess";
	        }else {
				return "loginFail";
			}
	    }
	    
	    public void setLoginStatus(HttpServletResponse response,AccountModel accountModel){
	    	User user = MyBatis.getUserByName(accountModel.getUsername());
	    	Login_status login_status = new Login_status();
	    	login_status.setKey(UUID.randomUUID().toString());
	    	login_status.setUser_id(user.getId());
	    	login_status.setTime(System.currentTimeMillis());
	    	MyBatis.createLogin_status(login_status);
	    	SetCookie(response, Constant.LOGIN_COOKIE_KEY, login_status.getKey());
	    }
	    
	    public boolean checkLogginStatus(HttpServletRequest request, HttpServletResponse response){
	    	String login_key = getCookie(request, Constant.LOGIN_COOKIE_KEY);
	    	if(StringUtils.isNullOrEmpty(login_key)){
	    		return false;
	    	}
	    	Login_status login_status = MyBatis.getLogin_status(login_key);
	    	if(null == login_status){
	    		return false;
	    	}
	    	long time = System.currentTimeMillis() - login_status.getTime();
	    	System.out.println("until last login:"+time);
	    	if(time > 5*60*1000){
	    		MyBatis.deleteLogin_status(login_status.getKey());
	    		return false;
	    	}else {
//	    		login_status.setUser_id(user.getId());
	    		login_status.setTime(System.currentTimeMillis());
	    		MyBatis.updateLogin_status(login_status);
				return true;
			}
	    }
	    
	    public String getCookie(HttpServletRequest request, String key){
	    	Cookie[] cookies = request.getCookies();
	    	
	    	for(Cookie cookie: cookies){
	    		if(cookie.getName().equals(key)){
	    			System.out.println("cookie:"+key+"$"+cookie.getValue());
	    			cookie.setMaxAge(Constant.COOKIE_TIME);
	    			return cookie.getValue();
	    		}
	    	}
	    	return null;
	    }
	    
	    public void SetCookie(HttpServletResponse response, String key, String value){
	    	Cookie cookie = new Cookie(key, value);
	    	cookie.setMaxAge(Constant.COOKIE_TIME);
	    	response.addCookie(cookie);
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
	        user.setNumber(accountModel.getPhone());
	        user.setInfo("123");
	        if(user.getType()==0){
	        	user.setType(1);
	        }
	        MyBatis.createUser(user);
	        model.addAttribute("accountmodel", accountModel);
	        return "registerSuccess";
	    }
}
