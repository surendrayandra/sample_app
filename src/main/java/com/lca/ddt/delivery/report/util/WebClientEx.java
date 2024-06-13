package com.lca.ddt.delivery.report.util;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

public class WebClientEx {

	

	String connectionProviderName = "myConnectionProvider";
	int maxConnections = 100;
	

	HttpClient httpClient = HttpClient.create(ConnectionProvider.
			create(connectionProviderName, maxConnections))
			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
			 .option(ChannelOption.SO_KEEPALIVE, true)
			  .option(EpollChannelOption.TCP_KEEPIDLE, 300)
			  .option(EpollChannelOption.TCP_KEEPINTVL, 60)
			  .option(EpollChannelOption.TCP_KEEPCNT, 8).
			responseTimeout(Duration.ofMillis(5000))
			.doOnConnected(conn -> conn.
					addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
					.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
					
					);

	WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
			.baseUrl("http://localhost:8080/").
			// defaultCookie("cookieKey", "cookieValue")
			// .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080/")).build();

	public Mono<String> getEmployees() {
		System.out.println("calling");
		return this.webClient.get().uri("/health").retrieve().bodyToMono(String.class);
	}

	public static void main(String[] args) throws InterruptedException {
		WebClientEx webClientEx = new WebClientEx();

		webClientEx.getEmployees().subscribe(createdEmployee -> {
			// Handle the successful response
			System.out.println("Got response from api: " + createdEmployee);
		}, error -> {
			// Handle errors
			System.err.println("Error creating employee: " + error.getMessage());
		});

		Thread.sleep(100000);
		System.out.println("done");

		/*
		 * 
		 * // Synchronous call String responseBody = webClient.get() .uri("/resource")
		 * .retrieve() .bodyToMono(String.class) .block();
		 * System.out.println("Synchronous response: " + responseBody);
		 * 
		 * // Asynchronous call webClient.get() .uri("/resource") .retrieve()
		 * .bodyToMono(String.class) .subscribe(response -> {
		 * System.out.println("Asynchronous response: " + response); });
		 * 
		 * 
		 */

	}

}
