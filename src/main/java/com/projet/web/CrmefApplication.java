package com.projet.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class CrmefApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmefApplication.class, args);
	}

}
