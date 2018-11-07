package com.my.project.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot项目启动类，主要用于做一些框架配置
 * <p>Title: CoreApplication<／p>
 * <p>Description: Spring Boot启动类，主要用于做一些框架配置<／p>
 * @author DengJinbo
 * @date 2018年11月5日
 */
@SpringBootApplication
public class CoreApplication {

	/**
	 * Spring Boot项目启动方法
	 * <p>Title: main<／p>
	 * <p>Description: Spring Boot项目启动方法，运行main方法即可启动整个项目<／p>
	 * @author DengJinbo
	 * @date 2018年11月5日
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
