package com.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import com.mchange.lang.ArrayUtils;

public class Test02 {
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		 
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken("zhangsan","123456");
		subject.login(token);
		System.out.println("登录成功");
		 boolean flag = subject.hasRole("super");
		 System.out.println(flag);
		 boolean flag2 = subject.isPermitted("add");
		 System.out.println(flag2);
		 List<String> list= new ArrayList<String>(); 
		 list.add("techer");
		 list.add("students");
		 boolean[] roles = subject.hasRoles(list);
		 for (boolean b : roles) {
			System.out.println(b);
		}
		 System.out.println(Arrays.toString(roles));
	}

}
