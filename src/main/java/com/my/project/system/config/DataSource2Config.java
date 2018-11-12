package com.my.project.system.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @Title DataSource2Config.java
 * @Description 数据源2配置
 * @author DengJinbo
 * @date 2018年11月9日
 */
@Configuration
@MapperScan(basePackages = "com.my.project.system.mapper.dao2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSource2Config {

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db2")
	@Primary
	public DruidDataSource dataSource2() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "sqlSessionFactory2")
	@Primary
	public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DruidDataSource druidDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(druidDataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpathmapper/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "transactionManager2")
	@Primary
	public DataSourceTransactionManager transactionManager2(
			@Qualifier("dataSource2") DruidDataSource druidDataSource) {
		return new DataSourceTransactionManager(druidDataSource);
	}

	@Bean(name = "sqlSessionTemplate2")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate2(
			@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
