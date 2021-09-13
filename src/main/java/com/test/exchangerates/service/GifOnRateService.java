package com.test.exchangerates.service;

import org.springframework.http.ResponseEntity;

public interface GifOnRateService {
    ResponseEntity<byte[]> getGif(String currency);
}
