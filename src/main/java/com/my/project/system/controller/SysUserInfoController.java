package com.my.project.system.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.project.system.domain.SysUser;
import com.my.project.system.service.SysUserInfoService;

/**
 * @Title SysUserInfoController.java
 * @Description 系统用户信息控制器
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Controller
@RequestMapping(value = "/sysUserInfo")
public class SysUserInfoController {
	
	@Resource
	private SysUserInfoService sysUserInfoService;
	
	/**
	 * @Title findByUserName 
	 * @Description 根据用户名查询系统用户实体，判断用户名唯一性
	 * @author DengJinbo
	 * @date 2018年11月15日
	 * @version 1.0
	 * @param userName 用户名
	 * @return
	 */
	@RequestMapping(value = "/findByUserName")
	public String findByUserName(String userName) {
		SysUser sysUser = sysUserInfoService.findByUserName(userName);
		if (sysUser != null) {
			return "success";
		}
		return "fail";
	}

	/**
	 * @Title userList 
	 * @Description 系统用户列表
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/userList")
	@RequiresPermissions("sysUser:view")
	public String userList() {
		return "sysUserList";
	}

	/**
	 * @Title userAdd 
	 * @Description 新增系统用户
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/userAdd")
	@RequiresPermissions("sysUser:add")
	public String userAdd() {
		return "userAdd";
	}

	/**
	 * @Title userEdit 
	 * @Description 修改系统用户
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/userEdit")
	@RequiresPermissions("sysUser:edit")
	public String userEdit() {
		return "userEdit";
	}

}
