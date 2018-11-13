package com.my.project.system.service;

import java.util.List;

import com.my.project.system.domain.SysRole;

/**
 * @Title SysRoleService.java
 * @Description 系统角色Service层接口
 * @author DengJinbo
 * @date 2018年11月13日
 */
public interface SysRoleService {

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
}
