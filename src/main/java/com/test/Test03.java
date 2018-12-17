package com.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test03 {
	public static void main(String[] args) {
		Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro_jdbc.ini");
		
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		//获得当前对象
		Subject subject = SecurityUtils.getSubject();
		//创建TOKEN
		UsernamePasswordToken token =new UsernamePasswordToken("admin","666");
		
	try{	
		subject.login(token);
		System.out.println("登录成功！");
		boolean b = subject.hasRole("system");
		System.out.println(b);
	     
		boolean flag2 = subject.isPermitted("update");
		System.out.println(flag2);
	}catch(Exception e){
		System.out.println("验证失败 账号或者密码错误！");
	}
	  Factory<SecurityManager> factory1=  new	IniSecurityManagerFactory("");
	     SecurityManager instance = factory1.getInstance();
	      SecurityUtils.setSecurityManager(instance);
	      Subject subject2 = SecurityUtils.getSubject();
	      UsernamePasswordToken toke= new UsernamePasswordToken("","");
	      subject2.login(toke);
	     /* subject2.hasRole(arg0)
	      subject2.isPermitted(arg0)*/
		
	}

}
