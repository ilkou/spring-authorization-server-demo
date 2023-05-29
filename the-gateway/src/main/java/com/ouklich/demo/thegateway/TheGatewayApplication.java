package com.ouklich.demo.thegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheGatewayApplication.class, args);
	}

	/** route incoming requests to the resource server app */
	@Bean
	RouteLocator gateway(RouteLocatorBuilder rlb) {

		// requests to /api/** are redirected to localhost:8081/**
		// and add the GatewayFilterSpec::tokenRelay too
		return rlb.routes()
				.route(rs -> rs.path("/api/**")
						.filters(gfs -> gfs.stripPrefix(1).tokenRelay())
						.uri("http://localhost:8081"))
				.build();
	}

}

