package com.my.project.system.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.my.project.system.domain.SysUser;
import com.my.project.system.service.SysUserInfoService;

/**
 * @Title MyshiroRealm.java
 * @Description
 * @author DengJinbo
 * @date 2018年11月13日
 */
public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private SysUserInfoService sysUserInfoService;

	/**
	 * @Title doGetAuthorizationInfo 
	 * @Description 配置权限，注入权限
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @param principalCollection
     * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
		for (Long roleId : sysUserInfoService.listRoleIdByUserId(sysUser.getId())) {
			// 查询用户所有的角色注入控制器
			authorizationInfo.addRole(sysUserInfoService.findRoleById(roleId).getRole());
			for (Long permissionId : sysUserInfoService.listPermissionIdByRoleId(roleId)) {
				// 查询用户所有的权限注入控制器
				authorizationInfo.addStringPermission(sysUserInfoService.findPermissionById(permissionId).getPermission());
			}
		}
		return authorizationInfo;
	}

	/**
	 * @Title doGetAuthenticationInfo 
	 * @Description 用户验证
	 * @param authenticationToken 系统用户数据
     * @return
     * @throws AuthenticationException 根据账户数据查询账户，根据账户状态抛出对应的异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		System.out.println("我在执行登陆验证-----");
		String userName = authenticationToken.getPrincipal().toString();
		SysUser sysUser = sysUserInfoService.findByUserName(userName);
		if (sysUser == null) {
			return null;
		}
		SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(userName, sysUser.getPassword(),
				ByteSource.Util.bytes(sysUser.getCredentialsSalt()), getName());
		return authorizationInfo;
	}

}
