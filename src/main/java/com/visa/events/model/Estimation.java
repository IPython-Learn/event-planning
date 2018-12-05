package com.visa.events.model;

import java.io.Serializable;
import java.util.Objects;

public class Estimation implements Serializable {


    public Estimation() {

    }

    public Estimation(String referenceId) {
        this.referenceId = referenceId;
    }

    private String referenceId;


    public double totalEstimation;

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

    public double getTotalEstimation() {
        return totalEstimation;
    }

    public void setTotalEstimation(double totalEstimation) {
        this.totalEstimation = totalEstimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estimation)) {
            return false;
        }
        Estimation that = (Estimation) o;
        return Double.compare(that.totalEstimation, totalEstimation) == 0 &&
                Objects.equals(referenceId, that.referenceId) &&
                Objects.equals(estimationDetails, that.estimationDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(referenceId, totalEstimation, estimationDetails);
    }


    @Override
    public String toString() {
        return "Estimation{" +
                "referenceId='" + referenceId + '\'' +
                ", totalEstimation=" + totalEstimation +
                ", estimationDetails=" + estimationDetails +
                '}';
    }
}



