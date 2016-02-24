package com.demo.web.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.web.utils.User;

public class MyBatis {
	static ApplicationContext ctx=null;
	static UserMapper userMapper=null;
	static Login_status_Mapper login_status_Mapper = null;
    static {
    	ctx=new ClassPathXmlApplicationContext("classpath:springservlet-config.xml");
    	userMapper=(UserMapper) ctx.getBean("userMapper");
    	login_status_Mapper = (Login_status_Mapper) ctx.getBean("login_status_Mapper");
    }

//    public static void main(String[] args) {
//        createUser(123);
//        getUser();
//    }

	public static void createUser(User user) {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
    	
        userMapper.insertUser(user);
    }

    public static User getUserByName(String name) {
    	
    	User user = userMapper.getUserByName(name);
    	return user;
    }
    
    public static User getUserById(long l) {
    	
    	User user = userMapper.getUserById(l);
    	return user;
    }
    
    public static void createLogin_status(Login_status login_status){
    	login_status_Mapper.insertLogin_status(login_status);
    }
    
    public static void deleteLogin_status(String key){
    	login_status_Mapper.deleteLogin_status(key);
    }
    
    public static void updateLogin_status(Login_status login_status){
    	login_status_Mapper.updateLogin_status(login_status);
    }
    
    public static Login_status getLogin_status(String key){
    	Login_status login_status = login_status_Mapper.getLogin_status(key);
    	return login_status;
    }
}
