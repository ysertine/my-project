package com.my.project.system.mapper.dao1;

import java.util.List;

import com.my.project.system.domain.SysRole;

/**
 * 系统角色DAO层接口
 * <p>Title: SysRoleDao<／p>
 * <p>Description: 系统角色DAO层接口<／p>
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysRoleDao {

	/**
	 * 根据系统权限ID获取系统权限实体
	 * <p>Title: selectRoleById<／p>
	 * <p>Description: 根据系统权限ID获取系统权限实体<／p>
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @param id 系统角色ID
	 * @return
	 */
	SysRole selectRoleById(Long id);
	
	/**
	 * 根据系统用户Id查询角色ID列表
	 * <p>Title: ListRoleIdByUserId<／p>
	 * <p>Description: 根据系统用户Id查询角色ID列表<／p>
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @param userId 系统用户ID
	 * @return
	 */
	List<Long> listRoleIdByUserId(Long userId);
}
