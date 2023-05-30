package com.example.thsensor.data.provider;

import com.example.thsensor.data.entity.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

interface DataProvider<T> {
    ArrayList<T> selectAll(ResponseHandler<List<T>> handler);
    void deleteAll();
    T selectSingle(ResponseHandler<List<T>> handler, Long id);
    void deleteSingle(Long id);
}
