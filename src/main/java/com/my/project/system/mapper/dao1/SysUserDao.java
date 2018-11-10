package com.my.project.system.mapper.dao1;

import com.my.project.system.domain.SysUser;

/**
 * 系统用户DAO层接口
 * <p>Title: SysUserDao<／p>
 * <p>Description: 系统用户DAO层接口<／p>
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysUserDao {

	/**
	 * 根据系统用户名查询用户
	 * <p>Title: selectByUsername<／p>
	 * <p>Description: 根据系统用户名查询用户<／p>
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @param userName 系统用户名
	 * @return
	 */
	SysUser selectByUsername(String userName);
	
	
}
