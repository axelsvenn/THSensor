package com.example.thsensor.data.entity;

public interface ResponseHandler<T> {
    void process(T response);
}
