package com.test.exchangerates.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "download-service", url = "https://placeholder")
public interface GifDownloadClient {

    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI baseUrl);

}
