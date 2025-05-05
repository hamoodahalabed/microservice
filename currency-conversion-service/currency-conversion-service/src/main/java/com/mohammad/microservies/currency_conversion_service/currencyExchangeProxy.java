package com.mohammad.microservies.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// when add eureka server you can use service name only
//@FeignClient(name = "currency-exchange", url = "http://localhost:8000")
@FeignClient(name = "currency-exchange-service")
public interface currencyExchangeProxy {


  @GetMapping("/currency-exchange/{from}/to/{to}")
  CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
