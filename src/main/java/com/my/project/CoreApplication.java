package com.my.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Title CoreApplication.java
 * @Description Spring Boot启动类，主要用于做一些框架配置。
 * 	启动类中添加mapper包扫描注解@MapperScan，这样就不用再每个maper中加注解。
 * 	修改启动类，继承SpringBootServletInitializer
 * @author DengJinbo
 * @date 2018年11月5日
 */
@SpringBootApplication
@MapperScan("com.my.project.*.dao")
public class CoreApplication extends SpringBootServletInitializer {

	/**
	 * @Title main 
	 * @Description Spring Boot项目启动方法，运行main方法即可启动整个项目
	 * @author DengJinbo
	 * @date 2018年11月5日
	 * @version 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
	
	/**
	 * @Description 重写configure方法，把启动类CoreApplication注册进去。
	 * 	外部web应用服务器构建Web Application Context的时候，会把启动类添加进去。
	 * @author DengJinbo
	 * @date 2018年12月3日
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoreApplication.class);
	}
}
