package com.lca.ddt.delivery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRetry
@EnableScheduling
@ComponentScan("com.lca.ddt")
public class IrisReportTransformer {

	public static void main(String[] args) {
		SpringApplication.run(IrisReportTransformer.class, args);
		System.out.println("hai test@@@@");
		System.out.println("QA");
		
		
	}

}
