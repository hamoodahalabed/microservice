package com.mohammad.microservies.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

  private final currencyExchangeProxy proxy;
  private final RestTemplate restTemplate;

  public CurrencyConversionController(currencyExchangeProxy proxy, RestTemplate restTemplate) {
    this.proxy = proxy;
    this.restTemplate = restTemplate;
  }

  // Uncomment the following method to use Feign client
//  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//  public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
//
//    HashMap<String, String> uriVariables = new HashMap<>();
//    uriVariables.put("from", from);
//    uriVariables.put("to", to);
//
//    ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
//        "http://localhost:8000/currency-exchange/{from}/to/{to}",
//        CurrencyConversion.class,
//        uriVariables);
//
//    CurrencyConversion currencyConversion = responseEntity.getBody();
//
//    return new CurrencyConversion(
//        currencyConversion.getId(),
//        from,
//        to,
//        quantity,
//        currencyConversion.getConversionMultiple(),
//        quantity.multiply(currencyConversion.getConversionMultiple()),
//        currencyConversion.getEnvironment()
//    );
//  }

  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {


    CurrencyConversion currencyConversion = proxy.getExchangeValue(from, to);

    return new CurrencyConversion(
        currencyConversion.getId(),
        from,
        to,
        quantity,
        currencyConversion.getConversionMultiple(),
        quantity.multiply(currencyConversion.getConversionMultiple()),
        currencyConversion.getEnvironment()
    );
  }
}
