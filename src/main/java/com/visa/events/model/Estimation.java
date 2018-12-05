package com.visa.events.model;

import java.io.Serializable;

public class Estimation implements Serializable {


    public Estimation() {

    }

    public Estimation(String referenceId) {
        this.referenceId = referenceId;
    }

    private String referenceId;


    public double estimation;

    public EstimationDetails estimationDetails;

    public EstimationDetails getEstimationDetails() {
        return estimationDetails;
    }

    public void setEstimationDetails(EstimationDetails estimationDetails) {
        this.estimationDetails = estimationDetails;
    }

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


}



