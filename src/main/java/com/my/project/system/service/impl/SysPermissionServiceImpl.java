package com.my.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.system.dao.SysPermissionDao;
import com.my.project.system.domain.SysPermission;
import com.my.project.system.service.SysPermissionService;

/**
 * @Title SysPermissionService.java
 * @Description 
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Service(value = "sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

	/**
	 * 注入sysPermissionDao
	 */
	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	@Override
	public SysPermission findPermissionById(Long id) {
		return sysPermissionDao.selectPermissionById(id);
	}

	@Override
	public List<Long> listPermissionIdByRoleId(Long roleId) {
		return sysPermissionDao.selectPermissionIdByRoleId(roleId);
	}

}
