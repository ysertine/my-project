package com.my.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.project.system.domain.SysUser;
import com.my.project.system.mapper.dao1.SysUserDao;
import com.my.project.system.service.SysUserService;

/**
 * @Title SysUserServiceImpl.java
 * @Description 系统用户Service实现类
 * @author DengJinbo
 * @date 2018年11月12日
 */
public class SysUserServiceImpl implements SysUserService {

	/**
	 * 注入SysUserDao
	 */
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public SysUser selectByUsername(String userName) {
		return sysUserDao.selectByUsername(userName);
	}

}
