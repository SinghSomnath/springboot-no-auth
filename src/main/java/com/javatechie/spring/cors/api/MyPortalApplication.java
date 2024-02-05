package com.javatechie.spring.cors.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/*@CrossOrigin(origins="*")*/
public class MyPortalApplication {
	
	/*@CrossOrigin(origins="http://localhost:9090")*/
	@GetMapping("/access")
	@CrossOrigin(origins="*")
	public String greeting() {
		return "Welcome to java techie portal";
	}

	@Autowired
	private EmployeeDAO employeeDao;
	@CrossOrigin(origins = "*")
	@GetMapping(path="/employees", produces = "application/json")
	public Employees getEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	
//	@Bean
//	public WebMvcConfigurer configure() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/*").allowedOrigins("http://localhost:9090");
//			}
//
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(MyPortalApplication.class, args);
	}

}
