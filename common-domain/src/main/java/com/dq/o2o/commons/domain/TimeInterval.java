package com.dq.o2o.commons.domain;

import java.io.Serializable;

public class TimeInterval<T> implements Serializable {
    private T startTime;
    private T endTime;

    public TimeInterval() {
    }

    public TimeInterval(T startTime, T endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public T getStartTime() {
        return this.startTime;
    }

    public void setStartTime(T startTime) {
        this.startTime = startTime;
    }

    public T getEndTime() {
        return this.endTime;
    }

    public void setEndTime(T endTime) {
        this.endTime = endTime;
    }
}
