package com.my.project.system.service;

import java.util.List;

import com.my.project.system.domain.SysPermission;

/**
 * @Title SysPermissionService.java
 * @Description 
 * @author DengJinbo
 * @date 2018年11月13日
 */
public interface SysPermissionService {

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
