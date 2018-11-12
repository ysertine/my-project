package com.my.project.system.service;

import com.my.project.system.domain.SysUser;

/**
 * @Title SysUserService.java
 * @Description 系统用户Service层接口
 * @author DengJinbo
 * @date 2018年11月12日
 */
public interface SysUserService {

	/**
	 * @Title selectByUsername 
	 * @Description 根据系统用户名查询用户
	 * @author DengJinbo
	 * @date 2018年11月12日
	 * @version 1.0
	 * @param userName 系统用户名
	 * @return 用户实体
	 */
	SysUser selectByUsername(String userName);
}
