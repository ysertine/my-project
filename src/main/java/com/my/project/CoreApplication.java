package com.my.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title CoreApplication.java
 * @Description Spring Boot启动类，主要用于做一些框架配置。
 * 		启动类中添加mapper包扫描注解@MapperScan，这样就不用再每个maper中加注解。
 * @author DengJinbo
 * @date 2018年11月5日
 */
@MapperScan("com.my.project.*.dao")
@SpringBootApplication
public class CoreApplication {

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
}
