package com.my.project.system.service;

import java.util.List;

import com.my.project.system.domain.SysPermission;
import com.my.project.system.domain.SysRole;
import com.my.project.system.domain.SysUser;

/**
 * @Title SysUserInfoService.java
 * @Description 系统用户信息Service层接口
 * @author DengJinbo
 * @date 2018年11月12日
 */
public interface SysUserInfoService {

	/**
	 * @Title findByUsername 
	 * @Description 根据系统用户名查询用户
	 * @author DengJinbo
	 * @date 2018年11月12日
	 * @version 1.0
	 * @param userName 系统用户名
	 * @return 用户实体
	 */
	SysUser findByUserName(String userName);
	
	/**
	 * @Title findRoleById 
	 * @Description 根据系统角色ID查询系统角色实体
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @param id 系统角色ID
	 * @return 系统角色实体
	 */
	SysRole findRoleById(Long id);
	
	/**
	 * @Title listRoleIdByUserId 
	 * @Description 根据系统用户ID查询系统角色ID列表
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @param userId 系统用户ID
	 * @return 系统角色ID列表
	 */
	List<Long> listRoleIdByUserId(Long userId);
	
	/**
	 * @Title findPermissionById 
	 * @Description 根据系统权限ID查询系统权限实体
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @param id 系统权限ID
	 * @return 系统权限实体
	 */
	SysPermission findPermissionById(Long id);
	
	/**
	 * @Title listPermissionIdByRoleId 
	 * @Description 根据系统角色ID获取系统权限ID列表
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @param roleId 系统角色ID
	 * @return 系统权限ID列表
	 */
	List<Long> listPermissionIdByRoleId(Long roleId);
}
