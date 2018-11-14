package com.my.project.system.database;

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
 * @Title DataSource1Config.java
 * @Description 数据源1配置
 * @author DengJinbo
 * @date 2018年11月9日
 */
@Configuration
@MapperScan(basePackages = "com.my.project.system.dao", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSource1Config {

	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db1")
	@Primary
	public DruidDataSource dataSource1() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "sqlSessionFactory1")
	@Primary
	public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DruidDataSource druidDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(druidDataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper1/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "transactionManager1")
	@Primary
	public DataSourceTransactionManager transactionManager1(
			@Qualifier("dataSource1") DruidDataSource druidDataSource) {
		return new DataSourceTransactionManager(druidDataSource);
	}

	@Bean(name = "sqlSessionTemplate1")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate1(
			@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
