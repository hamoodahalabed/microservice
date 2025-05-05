//package com.mohammad.microservies.currency_conversion_service;
//
//import feign.Feign;
//import feign.micrometer.MicrometerCapability;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.observation.ObservationRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignObservationConfig {
//
//  @Bean
//  public Feign.Builder feignBuilder(ObservationRegistry observationRegistry) {
//    return Feign.builder().addCapability(new MicrometerCapability(
//        (MeterRegistry) observationRegistry));
//  }
//}