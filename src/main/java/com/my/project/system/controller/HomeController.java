package com.my.project.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * @Description 注册控制
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/register")
	public String register() {
		return "/register";
	}

	/**
	 * @Title login 
	 * @Description 登陆控制
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("账号不存在");
				msg = "账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("密码不正确");
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("验证码不正确");
			} else {
				msg = "else  " + exception;
				System.out.println("else  " + exception);
			}
		}
		map.put("msg", msg);
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
		return "/index";
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
}
