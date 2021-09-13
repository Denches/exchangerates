package com.test.exchangerates;

import java.util.Map;

public class Rate {

    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String , Double> rates;

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

}
