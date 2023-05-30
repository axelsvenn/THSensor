package com.example.thsensor.data.provider;

import com.example.thsensor.data.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

interface DataProvider<T> {
    ArrayList<T> selectAll(ResponseHandler<List<T>> handler);
}
