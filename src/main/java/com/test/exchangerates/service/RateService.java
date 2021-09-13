package com.test.exchangerates.service;

import com.test.exchangerates.Rate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RateService {

    ResponseEntity<Rate> getRateMap(@PathVariable String date, @PathVariable String currency);

    List<Double> getRateHist(String currency);

}
