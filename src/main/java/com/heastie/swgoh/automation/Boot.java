package com.heastie.swgoh.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Boot {
	public static void main(final String[] args) {
		SpringApplication.run(Boot.class, args);
	}
}
