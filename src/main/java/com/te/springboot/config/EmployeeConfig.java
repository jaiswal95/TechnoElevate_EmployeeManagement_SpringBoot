package com.te.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EmployeeConfig {

	@Bean
	public LocalEntityManagerFactoryBean getFacBean() {

		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("empData");

		return bean;

	}// end of getFacBean

}//end of EmployeeConfig