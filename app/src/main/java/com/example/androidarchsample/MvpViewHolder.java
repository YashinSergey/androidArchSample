package com.example.androidarchsample;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchsample.presenters.BasePresenter;

public abstract class MvpViewHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    protected P presenter;

    public MvpViewHolder(View itemView) {
        super(itemView);
    }

    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.bindView(this);
    }

    public void unbindPresenter() {
        presenter = null;
    }
}
