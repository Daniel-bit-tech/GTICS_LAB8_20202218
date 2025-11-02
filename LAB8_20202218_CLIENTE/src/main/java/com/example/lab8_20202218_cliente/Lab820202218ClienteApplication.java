package com.example.lab8_20202218_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab820202218ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab820202218ClienteApplication.class, args);
	}
	@Bean

	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
