package com.example.multiforecastforecastservice.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Slf4j
public abstract class ApiClient {

  private final RestTemplate restTemplate;

  protected ApiClient(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Optional<String> sendGet(String url, HttpEntity<?> entity, Map<String, String> params) {

    log.debug("Request entity = {}\n params = {}", entity, params);
    String weather = null;
    try {
      weather = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params).getBody();
    } catch (HttpClientErrorException e) {
      log.error("Error during retrieving forecast", e);
    }

    return Optional.ofNullable(weather);
  }
}
