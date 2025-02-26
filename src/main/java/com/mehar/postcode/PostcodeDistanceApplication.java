package com.mehar.postcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mehar.postcode.repository")
public class PostcodeDistanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostcodeDistanceApplication.class, args);
	}
}
