package com.github.kairos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class KairosApplication {

	public static void main(String[] args) {
		SpringApplication.run(KairosApplication.class, args);
	}

}
