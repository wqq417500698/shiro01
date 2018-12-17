package com.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 
 * @author mcb
 * 创建时间 :2018年12月4日
 * 功能描述 : 自定义realm  测试
 */
public class Shiro05 {
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myshiro.ini");
		//得到当前安全对象
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken("zhangsan","123456");
		subject.login(token);
		boolean role = subject.hasRole("students");
		System.out.println(role);
		boolean flag = subject.isPermitted("add");
		System.out.println(flag);
		
	}

}
