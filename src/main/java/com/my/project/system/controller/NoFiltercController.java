package com.my.project.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title NoFiltercController.java
 * @Description 无过滤控制器，在/nofilter下的所有链接都可以匿名访问
 * @author DengJinbo
 * @date 2018年11月13日
 */
@Controller
@RequestMapping("/nofilter")
public class NoFiltercController {
 
	/**
	 * @Title nofilter 
	 * @Description 跳转无过滤资源
	 * @author DengJinbo
	 * @date 2018年11月13日
	 * @version 1.0
	 * @return
	 */
    @RequestMapping("/nofilter")
    public String nofilter(){
        return "static/nofilter";
    }
}
