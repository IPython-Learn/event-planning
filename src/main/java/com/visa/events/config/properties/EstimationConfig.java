package com.visa.events.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "events.estimation")
public class EstimationConfig {


    private List<String> discountedEvent;

    private List<String> flatFeeMonths;

    private Double unconditalWeatherFlatFee;

    private Double monthFlatFee;

    private Double eventDiscount;


    public List<String> getDiscountedEvent() {
        return discountedEvent;
    }

    public void setDiscountedEvent(List<String> discountedEvent) {
        this.discountedEvent = discountedEvent;
    }

    public List<String> getFlatFeeMonths() {
        return flatFeeMonths;
    }

    public void setFlatFeeMonths(List<String> flatFeeMonths) {
        this.flatFeeMonths = flatFeeMonths;
    }

    public Double getUnconditalWeatherFlatFee() {
        return unconditalWeatherFlatFee;
    }

    public void setUnconditalWeatherFlatFee(Double unconditalWeatherFlatFee) {
        this.unconditalWeatherFlatFee = unconditalWeatherFlatFee;
    }

    public Double getMonthFlatFee() {
        return monthFlatFee;
    }

    public void setMonthFlatFee(Double monthFlatFee) {
        this.monthFlatFee = monthFlatFee;
    }

    public Double getEventDiscount() {
        return eventDiscount;
    }

    public void setEventDiscount(Double eventDiscount) {
        this.eventDiscount = eventDiscount;
    }
}
