package com.springboot.employee.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/Employee/*").allowedOrigins("*").allowedMethods("POST","PUT","GET","DELETE");
				registry.addMapping("/Employee/*/*").allowedOrigins("*").allowedMethods("POST","PUT","GET","DELETE");
				registry.addMapping("/Employee/*/*/*").allowedOrigins("*").allowedMethods("POST","PUT","GET","DELETE");
			}
		};
	}
}
