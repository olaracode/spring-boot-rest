package com.example.demo;

import com.example.demo.run.Location;
import com.example.demo.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"First run",  LocalDateTime.now(),  LocalDateTime.now().plus(1, ChronoUnit.HOURS),5, Location.OUTDOOR);
			log.info("RUN: " + run);
		};
	}
}
