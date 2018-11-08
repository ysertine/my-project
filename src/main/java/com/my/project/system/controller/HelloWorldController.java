package com.my.project.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello world控制器
 * <p>Title: HelloWorldController<／p>
 * <p>Description: Spring Boot项目hello world，添加@RestController注解后，
 * 该controller里面的方法都以JSON格式输出，不用再写JackJson配置了！<／p>
 * @author DengJinbo
 * @date 2018年11月5日
 */
@RestController
public class HelloWorldController {

	/**
	 * hello方法
	 * <p>Title: hello<／p>
	 * <p>Description: hello方法<／p>
	 * @author DengJinbo
	 * @date 2018年11月5日
	 * @return “hello world!”
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}
}
