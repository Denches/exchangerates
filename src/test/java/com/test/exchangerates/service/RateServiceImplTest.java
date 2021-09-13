package com.test.exchangerates.service;

import com.test.exchangerates.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RateServiceImplTest {

    @Autowired
    private RateService rateService;

    @MockBean
    private GifService gifService;

    @Value("$(currency)")
    private String currency;

   @Test
    @DisplayName("Checking the correct response from the currency api")
    public void getCurrency() {

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String date = String.format("%04d-%02d-%02d", year, month, day);

        ResponseEntity<Rate> rate = rateService.getRateMap(date, currency);

        Assertions.assertEquals(rate.getStatusCodeValue(), 200);
        Assertions.assertNotNull(rate.getBody());
        Assertions.assertNotNull(Objects.requireNonNull(rate.getBody()).getRates());
    }
}