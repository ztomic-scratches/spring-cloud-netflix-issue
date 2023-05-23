package com.example.microservicea;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservice202202Application {

	@RestController
	class SampleController {
		private final String instanceId;

		SampleController(@Value("${spring.application.instance-id}") String instanceId) {
			this.instanceId = instanceId;
		}

		@GetMapping("/hello")
		public String hello() {
			return "Hello from " + instanceId + "@" + LocalDateTime.now();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Microservice202202Application.class, args);
	}

}
