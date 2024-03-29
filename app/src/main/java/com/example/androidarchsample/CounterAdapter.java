package com.example.androidarchsample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.androidarchsample.models.Counter;
import com.example.androidarchsample.presenters.CounterPresenter;
import com.example.androidarchsample.views.CounterViewHolder;


public class CounterAdapter extends MvpRecyclerListAdapter<Counter, CounterPresenter, CounterViewHolder> {

    @Override
    public CounterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CounterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.counter_row, parent, false));
    }

    @NonNull
    @Override
    protected CounterPresenter createPresenter(@NonNull Counter counter) {
        CounterPresenter presenter = new CounterPresenter();
        presenter.setModel(counter);
        return presenter;
    }

    @NonNull
    @Override
    protected Object getModelId(@NonNull Counter model) {
        return model.getId();
    }
}
