package com.my.project.system.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title HomeController.java
 * @Description 主页跳转控制器
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Controller
public class HomeController {

	/**
	 * @Title register
	 * @Description 注册
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * @Title login
	 * @Description 退出跳转登录，退出的时候是get请求
	 * @author DengJinbo
	 * @date 2018年11月14日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("-----get-----");
		return "login";
	}

	/**
	 * @Title login
	 * @Description post登录
	 * @author DengJinbo
	 * @date 2018年11月14日
	 * @version 1.0
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Map<String, Object> map) {
		System.out.println("-----post-----");
		System.out.println("username" + map.get("userName").toString());
		// 添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(map.get("userName").toString(),
				map.get("password").toString());
		// 进行验证，这里可以捕获异常，然后返回对应信息
		subject.login(usernamePasswordToken);
		return "login";
	}

	/**
	 * @Title index
	 * @Description 跳转首页控制
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping({ "/", "/index" })
	public String index() {
		return "index";
	}

	/**
	 * @Title logout
	 * @Description 登出
	 * @author DengJinbo
	 * @date 2018年11月14日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}

	/**
	 * @Title unAuthorizaRole
	 * @Description 跳转无权限控制
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/403")
	public String unAuthorizaRole() {
		System.out.println("没有权限");
		return "error/403";
	}

	/**
	 * @Title error
	 * @Description 错误页面
	 * @author DengJinbo
	 * @date 2018年11月14日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String error() {
		return "error ok!";
	}
}
