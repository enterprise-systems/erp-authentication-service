package com.enterprisesystems.erpauthenticationservice;

import java.time.ZonedDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ERP Authentication service", version = "1.0.0", contact = @Contact(name = "Richard", email = "richardvu.dev@gmail.com", url = "https://github.com/richardvu-dev"), license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT"), description = "ERP Authentication service"))
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
