package com.visa.events.model;

import com.visa.events.model.enums.EventType;

import java.io.Serializable;
import java.util.Objects;

public final class EstimationDetails implements Serializable {

    public double baseEstimation;

    public double musicalEventDiscount;

    public EventType discountedEvent;


    public double unconditionalWeatherFlatFee;

    public String weatherCondition;


    public double monthsFlatFee;

    public String monthFeeReason;

    public String eventDate;

    public String eventCity;


    public double getUnconditionalWeatherFlatFee() {
        return unconditionalWeatherFlatFee;
    }

    public void setUnconditionalWeatherFlatFee(double unconditionalWeatherFlatFee) {
        this.unconditionalWeatherFlatFee = unconditionalWeatherFlatFee;
    }

    public double getMonthsFlatFee() {
        return monthsFlatFee;
    }

    public void setMonthsFlatFee(double monthsFlatFee) {
        this.monthsFlatFee = monthsFlatFee;
    }

    public double getMusicalEventDiscount() {
        return musicalEventDiscount;
    }

    public void setMusicalEventDiscount(double musicalEventDiscount) {
        this.musicalEventDiscount = musicalEventDiscount;
    }

    public double getBaseEstimation() {
        return baseEstimation;
    }

    public void setBaseEstimation(double baseEstimation) {
        this.baseEstimation = baseEstimation;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getMonthFeeReason() {
        return monthFeeReason;
    }

    public void setMonthFeeReason(String monthFeeReason) {
        this.monthFeeReason = monthFeeReason;
    }

    public EventType getDiscountedEvent() {
        return discountedEvent;
    }

    public void setDiscountedEvent(EventType discountedEvent) {
        this.discountedEvent = discountedEvent;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EstimationDetails)) {
            return false;
        }
        EstimationDetails that = (EstimationDetails) o;
        return Double.compare(that.baseEstimation, baseEstimation) == 0 &&
                Double.compare(that.musicalEventDiscount, musicalEventDiscount) == 0 &&
                Double.compare(that.unconditionalWeatherFlatFee, unconditionalWeatherFlatFee) == 0 &&
                Double.compare(that.monthsFlatFee, monthsFlatFee) == 0 &&
                discountedEvent == that.discountedEvent &&
                Objects.equals(weatherCondition, that.weatherCondition) &&
                Objects.equals(monthFeeReason, that.monthFeeReason) &&
                Objects.equals(eventDate, that.eventDate) &&
                Objects.equals(eventCity, that.eventCity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseEstimation, musicalEventDiscount, discountedEvent, unconditionalWeatherFlatFee,
                weatherCondition, monthsFlatFee, monthFeeReason, eventDate, eventCity);
    }

    @Override
    public String toString() {
        return "EstimationDetails{" +
                "baseEstimation=" + baseEstimation +
                ", musicalEventDiscount=" + musicalEventDiscount +
                ", discountedEvent=" + discountedEvent +
                ", unconditionalWeatherFlatFee=" + unconditionalWeatherFlatFee +
                ", weatherCondition='" + weatherCondition + '\'' +
                ", monthsFlatFee=" + monthsFlatFee +
                ", monthFeeReason='" + monthFeeReason + '\'' +
                ", eventDate=" + eventDate +
                ", eventCity='" + eventCity + '\'' +
                '}';
    }
}
