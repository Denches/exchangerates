package com.test.exchangerates.client;

import com.test.exchangerates.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "gif-service", url = "${service.giphy.url}")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Gif> getRandomUrlGif(@RequestParam("api_key") String api_key,
                                        @RequestParam("tag") String tag);

}
