package com.my.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.system.dao.SysUserDao;
import com.my.project.system.domain.SysUser;
import com.my.project.system.service.SysUserService;

/**
 * @Title SysUserServiceImpl.java
 * @Description 系统用户Service实现类
 * @author DengJinbo
 * @date 2018年11月12日
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {

	/**
	 * 注入SysUserDao
	 */
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public SysUser findByUserName(String userName) {
		return sysUserDao.selectByUserName(userName);
	}

}
