package com.studentBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

}
