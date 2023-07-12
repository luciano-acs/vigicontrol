package com.api.VigiControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VigiControlApplication {

	public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(VigiControlApplication.class, args);
	}

}
