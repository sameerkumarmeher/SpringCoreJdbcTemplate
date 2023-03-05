package com.springcore.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.Dao.StudentDao;
import com.springcore.Dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.springcore.Dao")
public class JdbcConfig {

	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		//ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springCoreJdbc");
		ds.setUsername("root");
		ds.setPassword("Sameer@8249");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
//	
//	@Bean("studentDao")
//	public StudentDaoImpl getStudentDao()
//	{
//		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		studentDaoImpl.setJdbcTemplate(getTemplate());
//		return studentDaoImpl;
//		
//	}
}
