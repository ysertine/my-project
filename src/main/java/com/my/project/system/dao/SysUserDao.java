package com.my.project.system.dao;

import com.my.project.system.domain.SysUser;

/**
 * @Title SysUserDao.java
 * @Description 系统用户DAO层接口
 * @author DengJinbo
 * @date 2018年11月10日
 */
public interface SysUserDao {

	/**
	 * @Title selectByUsername 
	 * @Description 根据系统用户名查询系统用户
	 * @author DengJinbo
	 * @date 2018年11月10日
	 * @version 1.0
	 * @param userName 系统用户名
	 * @return 系统用户实体
	 */
	SysUser selectByUserName(String userName);
	
	
}
