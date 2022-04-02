package com.testessys.ApiSyss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class ApiSsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSsysApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
