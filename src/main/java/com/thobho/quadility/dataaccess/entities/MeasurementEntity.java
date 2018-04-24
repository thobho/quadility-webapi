package com.thobho.quadility.dataaccess.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "raw_measurement")
public class MeasurementEntity {
    @Id
    private String id;

    private double startLatt;
    private double startLong;
    private long startTimestamp;

    private double endLatt;
    private double endLong;
    private long endTimestamp;

    private float[] x;
    private float[] y;
    private float[] z;
    private long[] timestamps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getStartLatt() {
        return startLatt;
    }

    public void setStartLatt(double startLatt) {
        this.startLatt = startLatt;
    }

    public double getStartLong() {
        return startLong;
    }

    public void setStartLong(double startLong) {
        this.startLong = startLong;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public double getEndLatt() {
        return endLatt;
    }

    public void setEndLatt(double endLatt) {
        this.endLatt = endLatt;
    }

    public double getEndLong() {
        return endLong;
    }

    public void setEndLong(double endLong) {
        this.endLong = endLong;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public float[] getX() {
        return x;
    }

    public void setX(float[] x) {
        this.x = x;
    }

    public float[] getY() {
        return y;
    }

    public void setY(float[] y) {
        this.y = y;
    }

    public float[] getZ() {
        return z;
    }

    public void setZ(float[] z) {
        this.z = z;
    }

    public long[] getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(long[] timestamps) {
        this.timestamps = timestamps;
    }
}
