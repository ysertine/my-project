package com.my.project.system.mapper.dao1;

import java.util.List;

import com.my.project.system.domain.SysPermission;

/**
 * 系统权限DAO层接口
 * <p>Title: SysPermissionDao<／p>
 * <p>Description: 系统权限DAO层接口<／p>
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysPermissionDao {

	/**
	 * 根据系统权限ID查询权限实体
	 * <p>Title: selectPermissionById<／p>
	 * <p>Description: 根据系统权限ID查询权限实体<／p>
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @param id 系统权限ID
	 * @return
	 */
	SysPermission selectPermissionById(Long id);
	
	/**
	 * 根据系统角色ID获取权限ID列表
	 * <p>Title: listPermissionByRoleId<／p>
	 * <p>Description: 根据系统角色ID获取权限ID列表<／p>
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @param roleId 系统角色ID
	 * @return
	 */
	List<Long> listPermissionIdByRoleId(Long roleId);
}
