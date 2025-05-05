package com.mohammad.microservies.currency_conversion_service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  /**
   * This method creates a RestTemplate bean with a default configuration.
   * The RestTemplate is used to make HTTP requests to other services.
   * Need to do this to make Zipkin Tracing work with RestTemplate.
   *
   * @param builder the RestTemplateBuilder used to create the RestTemplate
   * @return a RestTemplate instance
   */
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder
        .build();
  }

}
