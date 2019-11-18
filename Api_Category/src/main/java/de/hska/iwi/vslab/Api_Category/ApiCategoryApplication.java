package de.hska.iwi.vslab.Api_Category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ApiCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCategoryApplication.class, args);
	}

}
