package com.my.project.system.mapper.dao1;

import java.util.List;

import com.my.project.system.domain.SysPermission;

/**
 * @Title SysPermissionDao.java
 * @Description 系统权限DAO层接口
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysPermissionDao {

	/**
	 * 
	 * @Title selectPermissionById 
	 * @Description 根据系统权限ID查询系统权限实体
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @version 1.0
	 * @param id 系统权限ID
	 * @return 系统权限实体
	 */
	SysPermission selectPermissionById(Long id);
	
	/**
	 * @Title listPermissionIdByRoleId 
	 * @Description 根据系统角色ID获取系统权限ID列表
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @version 1.0
	 * @param roleId 系统角色ID
	 * @return 系统权限ID列表
	 */
	List<Long> listPermissionIdByRoleId(Long roleId);
}
