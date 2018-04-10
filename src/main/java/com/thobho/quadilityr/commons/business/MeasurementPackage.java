package com.thobho.quadilityr.commons.business;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class MeasurementPackage {

    private Measurement[] measurements;

    public MeasurementPackage(@JsonProperty("measurements") Measurement[] measurements) {
        this.measurements = measurements;
    }

    public Measurement[] getMeasurements() {
        return measurements;
    }

    @Override
    public String toString() {
        return "MeasurementPackage{" +
                "measurementMessages=" + Arrays.toString(measurements) +
                '}';
    }
}
