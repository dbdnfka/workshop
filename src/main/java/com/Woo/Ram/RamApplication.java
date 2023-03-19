package com.Woo.Ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamApplication.class, args);

	}

}
