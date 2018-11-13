package com.my.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.system.dao.SysRoleDao;
import com.my.project.system.domain.SysRole;
import com.my.project.system.service.SysRoleService;

/**
 * @Title SysRoleServiceImpl.java
 * @Description 
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Service(value = "sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	
	/**
	 * 注入SysRoleDao
	 */
	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public SysRole findRoleById(Long id) {
		return sysRoleDao.selectRoleById(id);
	}

	@Override
	public List<Long> listRoleIdByUserId(Long userId) {
		return sysRoleDao.selectRoleIdByUserId(userId);
	}

}
