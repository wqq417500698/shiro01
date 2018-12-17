package com.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Shiro01 {
	
	public static void main(String[] args) {
		//创建安全工厂，读取存在的用户名 密码
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//shiro 核心安全对象实例
		 SecurityManager securityManager = factory.getInstance();
		 //为程序 设置安全管理
		 SecurityUtils.setSecurityManager(securityManager);
		 //获得当前用户实例
		 Subject subject =SecurityUtils.getSubject();
		 //创建token 用户输入用户名 密码进行登录
		 UsernamePasswordToken token=new UsernamePasswordToken("lisi","12345");
		 //进行登录
		 try{
		    subject.login(token);
		    System.out.println("登录完毕，登录成功");
		 }catch(Exception e){
			 System.out.println("用户名或密码错误");
		 }
		 
		//创建安全工厂 读取存在的用户名密码
			Factory<SecurityManager> fact=new IniSecurityManagerFactory("classpath:shiro.ini");
			//shiro 核心安全对象实例
			SecurityManager instance = fact.getInstance();
			//为程序设置安全管理
			SecurityUtils.setSecurityManager(instance);
			//获当前用户的实例
			Subject subject2 = SecurityUtils.getSubject();
			//创建token 用户输入用户名  密码进行登录
			UsernamePasswordToken token1 =new UsernamePasswordToken("","");
	}
		
	
                

}
