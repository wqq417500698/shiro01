package com.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 
 * @author mcb
 * 创建时间 :2018年12月4日
 * 功能描述 :  自定义realm  继承  实现方法
 */
public class MyRealm extends AuthorizingRealm{
    /**
     * 授权
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//通过PrincipalCollection 拿到用户的账号
		 String username =(String)principals.getPrimaryPrincipal();
		 ////通过数据库  查询 该用户的角色
		 //假设查询到了该角色是teacher
		 String role ="teacher";
		 //通过角色 得到他的权限
		 String permission="add";
		 SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
		 info.addStringPermission(permission);
		 info.addRole(role);
		return info;
	}
    /**
     * 认证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//通过token  拿到token 的账号
		String username=(String) token.getPrincipal();
		//通过数据库  查询 该账号的密码
		//假设已经查询到了 该密码为123456
		String  pws="123456";
		SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(username, pws,"打印日志");
		return info;
	}

}
