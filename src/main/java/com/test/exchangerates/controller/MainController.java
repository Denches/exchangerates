package com.test.exchangerates.controller;

import com.test.exchangerates.service.GifOnRateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MainController {

    private final GifOnRateService gifOnRateService;

   @Value("${currency}")
    private String currency;

    public MainController(GifOnRateService gifOnRateService) {
        this.gifOnRateService = gifOnRateService;
    }

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGif(@RequestParam("symbols") String currency) {

       return gifOnRateService.getGif(currency);
    }
    @GetMapping("/*")
    public ResponseEntity<byte[]> getGif() {

        return gifOnRateService.getGif(currency);
    }
}
