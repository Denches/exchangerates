package com.test.exchangerates.service.Impl;

import com.test.exchangerates.Gif;
import com.test.exchangerates.client.GifClient;
import com.test.exchangerates.service.GifService;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

@Service
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    public GifServiceImpl(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public String getRandomUrlGif(String api_key, String tag) {

        Gif gif = gifClient.getRandomUrlGif(api_key, tag.toUpperCase(Locale.ROOT)).getBody();

        return String.valueOf(Objects.requireNonNull(gif).getData().get("image_original_url"));
    }


}
