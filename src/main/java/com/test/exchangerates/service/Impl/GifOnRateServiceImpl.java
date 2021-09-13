package com.test.exchangerates.service.Impl;

import com.test.exchangerates.service.GifDownloadService;
import com.test.exchangerates.service.GifOnRateService;
import com.test.exchangerates.service.GifService;
import com.test.exchangerates.service.RateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class GifOnRateServiceImpl implements GifOnRateService {

    private final GifService gifService;
    private final RateService rateService;
    private final GifDownloadService gifDownloadService;

    @Value("${service.giphy.tag.rich}")
    private String rich;

    @Value("${service.giphy.tag.broke}")
    private String broke;

    @Value("${service.giphy.tag.error}")
    public String error;

    @Value("${service.giphy.tag.zero}")
    public String zero;

    @Value("${service.giphy.app.key}")
    public String appKey;

    public GifOnRateServiceImpl(GifService gifService, RateService rateService, GifDownloadService gifDownloadService) {
        this.gifService = gifService;
        this.rateService = rateService;
        this.gifDownloadService = gifDownloadService;
    }

    public ResponseEntity<byte[]> getGif(String currency) {

        String url;

        Double latestRate = rateService.getRateHist(currency).get(0);
        Double YesterdayRate = rateService.getRateHist(currency).get(1);

        if (latestRate == null) {
            url = gifService.getRandomUrlGif(appKey, error);
            URI basePathUri = URI.create(url);

            return gifDownloadService.getGifByUrl(basePathUri);
        }

        if (latestRate > YesterdayRate) {
            url = gifService.getRandomUrlGif(appKey, rich);
        } else if (latestRate.equals(YesterdayRate)) {
            url = gifService.getRandomUrlGif(appKey, zero);
        } else {
            url = gifService.getRandomUrlGif(appKey, broke);
        }

        URI basePathUri = URI.create(url);

        return gifDownloadService.getGifByUrl(basePathUri);
    }

}
