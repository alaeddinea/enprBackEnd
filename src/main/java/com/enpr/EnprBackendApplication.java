package com.enpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class EnprBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnprBackendApplication.class, args);
		
	}

	
}
