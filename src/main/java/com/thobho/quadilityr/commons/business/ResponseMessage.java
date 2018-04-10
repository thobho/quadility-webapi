package com.thobho.quadilityr.commons.business;

public class ResponseMessage {

    private Integer savedMeasurements;

    public ResponseMessage(Integer savedMeasurements) {
        this.savedMeasurements = savedMeasurements;
    }

    public Integer getSavedMeasurements() {
        return savedMeasurements;
    }

    public void setSavedMeasurements(Integer savedMeasurements) {
        this.savedMeasurements = savedMeasurements;
    }
}
