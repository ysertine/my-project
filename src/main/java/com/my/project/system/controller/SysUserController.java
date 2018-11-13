package com.my.project.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title SysUserController.java
 * @Description 系统用户信息控制器
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Controller
@RequestMapping("/sysUserInfo")
public class SysUserController {

	/**
	 * @Title userList 
	 * @Description 系统用户列表
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/userList")
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
	@RequestMapping("/userAdd")
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
	@RequestMapping("/userEdit")
	@RequiresPermissions("sysUser:edit")
	public String userEdit() {
		return "userEdit";
	}

}
