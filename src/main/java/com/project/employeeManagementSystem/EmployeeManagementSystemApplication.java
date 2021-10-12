package com.project.employeeManagementSystem;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 * EmployeeManagementSystemApplication is the starter class of the Employee management system
 * @since 08.10.2021
 */

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	// Fix the CORS errors
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {  
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
		CorsConfiguration config = new CorsConfiguration();  
		config.setAllowCredentials(true); 
		// *** URL below needs to match the Vue client URL and port ***
		config.setAllowedOrigins(Collections.singletonList("http://localhost:8081")); 
		config.setAllowedMethods(Collections.singletonList("*"));  
		config.setAllowedHeaders(Collections.singletonList("*"));  
		source.registerCorsConfiguration("/**", config);  
		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
		return bean;  
	}
}
