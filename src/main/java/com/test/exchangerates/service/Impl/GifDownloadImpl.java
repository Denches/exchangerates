package com.test.exchangerates.service.Impl;

import com.test.exchangerates.client.GifDownloadClient;
import com.test.exchangerates.service.GifDownloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class GifDownloadImpl implements GifDownloadService {

    private final GifDownloadClient client;

    public GifDownloadImpl(GifDownloadClient client){
        this.client = client;
    }

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI baseUrl) {

        return client.getGifByUrl(baseUrl);
    }
}
