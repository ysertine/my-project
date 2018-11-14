package com.my.project.system.database;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @Title DruidConfig.java
 * @Description Druid连接池监控配置
 * @author DengJinbo
 * @date 2018年11月9日
 */
@Configuration
public class DruidConfig {

	/**
	 * 注册servlet信息，配置监控图
	 * <p>Title druidServlet<／p>
	 * <p>Description 注册servlet信息，配置监控图<／p>
	 * @author DengJinbo
	 * @date 2018年11月9日
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		// 白名单
		servletRegistrationBean.addInitParameter("allow", "192.168.1.6");
		// IP黑名单(存在共同时，deny优先于allow)  
		// 如果满足deny的话提示Sorry, you are not permitted to view this page.
		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		// 用于登陆的账号密码
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		// 是否能重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;
	}

	/**
	 * 注册filter信息，用于拦截
	 * <p>Title filterRegistrationBean<／p>
	 * <p>Description 注册filter信息，用于拦截<／p>
	 * @author DengJinbo
	 * @date 2018年11月9日
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

}
