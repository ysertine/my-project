package com.my.project.system.mapper.dao1;

import java.util.List;

import com.my.project.system.domain.SysRole;

/**
 * @Title SysRoleDao.java
 * @Description 系统角色DAO层接口
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysRoleDao {

	/**
	 * @Title selectRoleById 
	 * @Description 根据系统角色ID获取系统角色实体
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @version 1.0
	 * @param id 系统角色ID
	 * @return 系统角色实体
	 */
	SysRole selectRoleById(Long id);
	
	/**
	 * @Title listRoleIdByUserId 
	 * @Description 根据系统用户Id查询系统角色ID列表
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @version 1.0
	 * @param userId 系统用户ID
	 * @return 系统角色ID列表
	 */
	List<Long> listRoleIdByUserId(Long userId);
}
