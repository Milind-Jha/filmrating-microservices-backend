package com.org.apigatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApigatewaydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewaydemoApplication.class, args);
	}

}
