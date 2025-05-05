package com.mohammad.microservies.currency_exchange_service.currency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  private final Environment environment;
  private final CurrencyExchangeRepository repository;
  private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

  public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
    this.repository = repository;
    this.environment = environment;
  }

  @GetMapping("/currency-exchange/{from}/to/{to}")
  public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {

    logger.info("getExchangeValue called with {} and to {}", from, to);

    CurrencyExchange exchangeValue = repository.findByFromAndTo(from, to);

    if (exchangeValue == null) {
      throw new RuntimeException("Unable to find data for " + from + " to " + to);
    }

    exchangeValue.setEnvironment(environment.getProperty("local.server.port"));

    return exchangeValue;
  }

}
