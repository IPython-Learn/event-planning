package com.visa.events.model;

public class Estimation {


    public Estimation() {

    }

    public Estimation(String referenceId) {
        this.referenceId = referenceId;
    }

    private String referenceId;

    public double estimation;

    public double unconditionalWeatherFlatFee;

    public double monthsFlatFee;

    public double musicalEventDiscount;

    public double finalEstimation;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


    public double getEstimation() {
        return estimation;
    }

    public void setEstimation(double estimation) {
        this.estimation = estimation;
    }


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

    public double getFinalEstimation() {
        return finalEstimation;
    }

    public void setFinalEstimation(double finalEstimation) {
        this.finalEstimation = finalEstimation;
    }
}
