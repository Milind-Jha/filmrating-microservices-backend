package com.org.filmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class FilmserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmserviceApplication.class, args);
	}

}
