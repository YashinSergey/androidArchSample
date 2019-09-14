package com.example.androidarchsample.views;


import com.example.androidarchsample.models.Counter;

import java.util.List;

public interface MainView {
    void showCounters(List<Counter> counters);

    void showLoading();

    void showEmpty();
}
