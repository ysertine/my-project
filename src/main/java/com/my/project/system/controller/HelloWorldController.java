package com.my.project.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title HelloWorldController.java
 * @Description Spring Boot项目hello world，添加@RestController注解后，
 * 		该controller里面的方法都以JSON格式输出，不用再写JackJson配置了！
 * @author DengJinbo
 * @date 2018年11月5日
 */
@RestController
public class HelloWorldController {

	/**
	 * @Title hello 
	 * @Description hello方法
	 * @author DengJinbo
	 * @date 2018年11月5日
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}
}
