package com.test.exchangerates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com" })
@EnableFeignClients
public class ExchangeratesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExchangeratesApplication.class, args);
    }

}
