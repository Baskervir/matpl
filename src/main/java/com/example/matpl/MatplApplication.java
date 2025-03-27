package com.example.matpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MatplApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatplApplication.class, args);
	}
}
