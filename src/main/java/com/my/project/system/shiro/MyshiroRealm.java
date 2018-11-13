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
import com.my.project.system.service.SysPermissionService;
import com.my.project.system.service.SysRoleService;
import com.my.project.system.service.SysUserService;

/**
 * @Title MyshiroRealm.java
 * @Description
 * @author DengJinbo
 * @date 2018年11月13日
 */
public class MyshiroRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserService;

	@Resource
	private SysRoleService sysRoleSercie;

	@Resource
	private SysPermissionService sysPermissionService;

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
		for (Long roleId : sysRoleSercie.listRoleIdByUserId(sysUser.getId())) {
			// 查询用户所有的角色注入控制器
			authorizationInfo.addRole(sysRoleSercie.findRoleById(roleId).getRole());
			for (Long permissionId : sysPermissionService.listPermissionIdByRoleId(roleId)) {
				// 查询用户所有的权限注入控制器
				authorizationInfo.addStringPermission(sysPermissionService.findPermissionById(permissionId).getPermission());
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
		System.out.println("我在执行登陆验证-----");
		String userName = (String) authenticationToken.getPrincipal();
		System.out.println("userName--" + authenticationToken);
		SysUser sysUser = sysUserService.findByUserName(userName);
		if (sysUser == null) {
			return null;
		}
		System.out.println("credentialsSalt--" + sysUser.getCredentialsSalt());
		System.out.println("password--" + sysUser.getPassword());
		SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(),
				ByteSource.Util.bytes(sysUser.getCredentialsSalt()), getName());
		return authorizationInfo;
	}

}
