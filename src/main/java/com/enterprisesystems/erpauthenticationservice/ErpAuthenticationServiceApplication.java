package com.enterprisesystems.erpauthenticationservice;

import java.time.ZonedDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class ErpAuthenticationServiceApplication {

	public static void main(String[] args) {
		log.info("ERP Authentication Service Application starting at: {}", ZonedDateTime.now().toString());
		SpringApplication.run(ErpAuthenticationServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
