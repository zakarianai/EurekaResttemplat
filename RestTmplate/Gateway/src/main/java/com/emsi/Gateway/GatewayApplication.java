package com.emsi.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


//	@Bean
//	RouteLocator routes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("clients/**").uri("lb://SERVICE-CLIENT"))
//				.build();
//	}


	// Routage statique
//	@Bean
//	public RouteLocator clientRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("client_all_route", r -> r.path("/clients")
//						.uri("http://localhost:8088"))
//				.route("client_by_id_route", r -> r.path("/clients/{id}")
//						.uri("http://localhost:8088"))
//				.build();
//	}

	// routage dynamique
	@Bean
	public DiscoveryClientRouteDefinitionLocator routesDynamique(
			ReactiveDiscoveryClient rdc,
			DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
}
