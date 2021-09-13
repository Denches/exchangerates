package com.test.exchangerates.service.Impl;

import com.test.exchangerates.Rate;
import com.test.exchangerates.client.RateClient;
import com.test.exchangerates.service.RateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RateServiceImpl implements RateService {

    @Value("${service.exchangerates.app.id}")
    private String appKey;

    private final RateClient rateClient;

    public RateServiceImpl(RateClient rateClient) {
        this.rateClient = rateClient;
    }

    private String historical(String sDay) {

        Calendar calendar = Calendar.getInstance();
        String historical;

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        if (sDay.equals("today")) {
            return String.format("%04d-%02d-%02d", year, month, day);
        } else {
            return String.format("%04d-%02d-%02d", year, month, day - 1);
        }
    }

    @Override
    public List<Double> getRateHist(String currency){

        ArrayList<Double> list = new ArrayList<>();
        Double latestRate = getRate(historical("today"), currency);
        Double YesterdayRate = getRate(historical(""), currency);;

        list.add(latestRate);
        list.add(YesterdayRate);

        return list;
    }

    private Double getRate(String date, String currency) {

        Rate rate = getRateMap(date, currency.toUpperCase(Locale.ROOT)).getBody();

        return Objects.requireNonNull(rate).getRates().get(currency);
    }

    @Override
    public ResponseEntity<Rate> getRateMap(String date, String currency) {

        return rateClient.getRate(date, appKey, currency);
    }


}
