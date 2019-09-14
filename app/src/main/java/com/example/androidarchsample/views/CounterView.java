package com.example.androidarchsample.views;


import com.example.androidarchsample.models.Counter;

public interface CounterView {
    void setCounterName(String name);

    void setCounterValue(int value);

    void setMinusButtonEnabled(boolean enabled);

    void setPlusButtonEnabled(boolean enabled);

    void goToDetailView(Counter counter);
}
