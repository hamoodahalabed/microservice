package com.mohammad.microservies.gateway_service;

import java.util.function.Function;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

  // or use properties file instead of this method
  @Bean
  public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    Function<PredicateSpec, Buildable<Route>> routeFunction
        = p-> p.path("/get") // Matches the path /get
        .filters(f -> f
            .addRequestHeader("Hello", "World")
            .addRequestParameter("request", "parameter")) // Adds a request header
        .uri("http://httpbin.org:80"); // URI to forward the request to
    return builder.routes()
        .route(routeFunction)
        .route(p -> p.path("/currency-exchange/**") // Matches the path /currency-exchange/** (if it match this url)
            .uri("lb://currency-exchange-service")) // Load balancer URI (go to this service name)
        .route(p -> p.path("/currency-conversion/**")
            .uri("lb://currency-conversion-service"))
        .build();
  }

}
