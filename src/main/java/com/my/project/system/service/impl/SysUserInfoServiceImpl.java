package com.my.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.system.dao.SysPermissionDao;
import com.my.project.system.dao.SysRoleDao;
import com.my.project.system.dao.SysUserDao;
import com.my.project.system.domain.SysPermission;
import com.my.project.system.domain.SysRole;
import com.my.project.system.domain.SysUser;
import com.my.project.system.service.SysUserInfoService;

/**
 * @Title SysUserInfoServiceImpl.java
 * @Description 系统用户信息Service接口实现类
 * @author DengJinbo
 * @date 2018年11月12日
 */
@Service(value = "sysUserInfoService")
public class SysUserInfoServiceImpl implements SysUserInfoService {

	/**
	 * 注入SysUserDao
	 */
	@Autowired
	private SysUserDao sysUserDao;
	
	/**
	 * 注入SysRoleDao
	 */
	@Autowired
	private SysRoleDao sysRoleDao;
	
	/**
	 * 注入sysPermissionDao
	 */
	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	@Override
	public SysUser findByUserName(String userName) {
		return sysUserDao.selectByUserName(userName);
	}
	
	@Override
	public SysRole findRoleById(Long id) {
		return sysRoleDao.selectRoleById(id);
	}

	@Override
	public List<Long> listRoleIdByUserId(Long userId) {
		return sysRoleDao.selectRoleIdByUserId(userId);
	}

	@Override
	public SysPermission findPermissionById(Long id) {
		return sysPermissionDao.selectPermissionById(id);
	}

	@Override
	public List<Long> listPermissionIdByRoleId(Long roleId) {
		return sysPermissionDao.selectPermissionIdByRoleId(roleId);
	}
}
