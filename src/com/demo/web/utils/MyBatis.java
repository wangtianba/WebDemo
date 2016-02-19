package com.demo.web.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.web.utils.User;

public class MyBatis {
	static ApplicationContext ctx=null;
	static UserMapper userMapper=null;
    static {
    	ctx=new ClassPathXmlApplicationContext("classpath:springservlet-config.xml");
    	userMapper=(UserMapper) ctx.getBean("userMapper");
    }

//    public static void main(String[] args) {
//        createUser(123);
//        getUser();
//    }

	public static void createUser(User user) {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
    	
        userMapper.insertUser(user);
    }

    public static User getUser(String name) {
    	
    	User user = userMapper.getUser(name);
    	return user;
    }
}
