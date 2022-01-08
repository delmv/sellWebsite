package com.spring.henallux.transpLux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class TranspLuxApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranspLuxApplication.class, args);
	}

}
