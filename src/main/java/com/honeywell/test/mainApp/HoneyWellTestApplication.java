package com.honeywell.test.mainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.honeywell.test")
public class HoneyWellTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoneyWellTestApplication.class, args);
	}

}
