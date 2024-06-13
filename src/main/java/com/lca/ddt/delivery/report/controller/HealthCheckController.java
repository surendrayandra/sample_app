package com.lca.ddt.delivery.report.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public Mono<String> health() throws InterruptedException {
		System.out.println("in heatlth controller");
		Thread.sleep(10000);
		return Mono.just("test");
	}

}
