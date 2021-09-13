package com.test.exchangerates.client;

import com.test.exchangerates.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "rate-service", url = "${service.exchangerates.url}")
public interface RateClient {

    @GetMapping("/{date}.json")
    ResponseEntity<Rate> getRate(@PathVariable("date") String date,
                                 @RequestParam("app_id") String appId,
                                 @RequestParam(value = "symbols", defaultValue = "RUB") String symbols);

}
