package com.example.thsensor.data;

public interface ResponseHandler<T> {
    void process(T response);
}
