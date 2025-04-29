package com.mohammad.microservies.currency_exchange_service.currency;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

  private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

  @GetMapping("/sample-api")
  //@Retry(name = "sample-api" , fallbackMethod = "hardCodedResponse") // sample api same as the name in the application.yml
  //@CircuitBreaker(name = "default" , fallbackMethod = "hardCodedResponse")
  @RateLimiter(name = "default")
  public String sampleApi() {
    logger.info("Sample API call received");
    return new RestTemplate().getForEntity(
        "http://localhost:8080/some-dummy-url", String.class).getBody();
  }

  public String hardCodedResponse(Exception ex) {
    logger.info("Fallback method called because the original method failed {}", ex.getMessage());
    return "fallback-response";
  }

}
