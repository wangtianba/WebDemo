//package com.demo.web.controllers;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.demo.web.models.AccountModel;
//
//@Controller
//@RequestMapping(value = "/helloworld")
//@SessionAttributes(value = "sessionaccountmodel",types=AccountModel.class)
//public class HelloWorldController {
//
////    @RequestMapping(value="/index", method = {RequestMethod.GET})
//	@RequestMapping(value={"/", "/index", "/hello"}, method = {RequestMethod.GET})
//    public ModelAndView index(){
//        
//        ModelAndView modelAndView = new ModelAndView();  
//        modelAndView.addObject("message", "Hello World!");  
//        modelAndView.setViewName("index");  
//        return modelAndView;
//    }
//	
//	@RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
//	public ModelAndView getDetail(@PathVariable(value="id") Integer id){
//	    
//	    ModelAndView modelAndView = new ModelAndView();  
//	    modelAndView.addObject("id", id);  
//	    modelAndView.setViewName("detail");  
//	    return modelAndView;
//	}
//	
//	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}", method = {RequestMethod.GET})
//	public ModelAndView regUrlTest(@PathVariable(value="name") String name, @PathVariable(value="age") Integer age){
//	    
//	    ModelAndView modelAndView = new ModelAndView();   
//	    modelAndView.addObject("name", name); 
//	    modelAndView.addObject("age", age); 
//	    modelAndView.setViewName("regurltest");  
//	    return modelAndView;
//	}
//	
//	@RequestMapping(value="/parambind", method = {RequestMethod.GET})
//    public ModelAndView paramBind(){
//        
//        ModelAndView modelAndView = new ModelAndView();  
//        modelAndView.setViewName("parambind");  
//        return modelAndView;
//    }
//    
//    @RequestMapping(value="/parambind", method = {RequestMethod.POST})
//    public ModelAndView paramBind(HttpServletRequest request, @RequestParam("urlParam") String urlParam, @RequestParam("formParam") String formParam, @RequestParam("formFile") MultipartFile formFile){
//        System.out.println("123");
//        //如果不用注解自动绑定，我们还可以像下面一样手动获取数据
//        String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
//        String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
//        MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile"); 
//        
//        ModelAndView modelAndView = new ModelAndView();  
//        modelAndView.addObject("urlParam", urlParam);  
//        modelAndView.addObject("formParam", formParam);  
//        modelAndView.addObject("formFileName", formFile.getOriginalFilename());  
//        
//        modelAndView.addObject("urlParam1", urlParam1);  
//        modelAndView.addObject("formParam1", formParam1);  
//        modelAndView.addObject("formFileName1", formFile1.getOriginalFilename());  
//        modelAndView.setViewName("parambindresult");  
//        return modelAndView;
//    }
//    
//    @RequestMapping(value="/modelautobind", method = {RequestMethod.GET})
//    public String modelAutoBind(HttpServletRequest request, Model model){
//        
//        model.addAttribute("accountmodel", new AccountModel());
//        return "modelautobind";
//    }
//
//    @RequestMapping(value="/modelautobind", method = {RequestMethod.POST})
//    public String modelAutoBind(HttpServletRequest request, Model model, AccountModel accountModel){
//        
//        model.addAttribute("accountmodel", accountModel);
//        System.out.println(accountModel.getUsername());
//        return "modelautobindresult";
//    }
//    
//  //@CookieValue Test
//    @RequestMapping(value="/cookiebind", method = {RequestMethod.GET})
//    public String cookieBind(HttpServletRequest request, Model model, @CookieValue(value="JSESSIONID", defaultValue="") String jsessionId){
//        
//        model.addAttribute("jsessionId", jsessionId);
//        return "cookiebindresult";
//    }
//    
//  //@RequestHeader Test
//    @RequestMapping(value="/requestheaderbind", method = {RequestMethod.GET})
//    public String requestHeaderBind(HttpServletRequest request, Model model, @RequestHeader(value="User-Agent", defaultValue="") String userAgent){
//        
//        model.addAttribute("userAgent", userAgent);
//        return "requestheaderbindresult";
//    }
//      
//    
//  //@SessionAttributes Test
//    @ModelAttribute("sessionaccountmodel")
//    public AccountModel initAccountModel(){
//        System.out.println("init");
//        return new AccountModel();
//    }
//
//    @RequestMapping(value="/usernamebind", method = {RequestMethod.GET})
//    public String userNameBind( Model model, AccountModel accountModel){
//        
//        model.addAttribute("sessionaccountmodel", new AccountModel());
//        return "usernamebind";
//    }
//
//    @RequestMapping(value="/usernamebind", method = {RequestMethod.POST}) 
//    public String userNameBindPost( @ModelAttribute("sessionaccountmodel") AccountModel accountModel){
//        
//        //重定向到密码绑定测试
//        return "redirect:passwordbind";
//    }
//
//    @RequestMapping(value="/passwordbind", method = {RequestMethod.GET})
//    public String passwordBind(@ModelAttribute("sessionaccountmodel") AccountModel accountModel){
//        
//        return "passwordbind";
//    }
//
//    @RequestMapping(value="/passwordbind", method = {RequestMethod.POST})
//    public String passwordBindPost(@ModelAttribute("sessionaccountmodel") AccountModel accountModel, SessionStatus status){
//        System.out.println("aaaa");
//        //销毁@SessionAttributes存储的对象
//        status.setComplete();
//        //显示绑定结果
//        return "sessionmodelbindresult";
//    }
//    
//  //@RequestBody Test
//    @RequestMapping(value="/requestbodybind", method = {RequestMethod.GET})
//    public String requestBodyBind(Model model){
//        System.out.println("123");
//        model.addAttribute("accountmodel", new AccountModel());
//        return "requestbodybind";
//    }
//
//    @RequestMapping(value="/requestbodybind", method = {RequestMethod.POST})
//    public @ResponseBody AccountModel requestBodyBind(@RequestBody AccountModel accountModel){
//    	System.out.println("777+"+accountModel.getUsername());
//        return accountModel;
//    }
//    
//}