package com.example.androidarchsample.views;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidarchsample.MvpViewHolder;
import com.example.androidarchsample.R;
import com.example.androidarchsample.models.Counter;
import com.example.androidarchsample.presenters.CounterPresenter;


public class CounterViewHolder extends MvpViewHolder<CounterPresenter> implements CounterView {
    private final TextView counterName;
    private final TextView counterValue;
    private final ImageView minusButton;
    private final ImageView plusButton;
    @Nullable private OnCounterClickListener listener;

    public CounterViewHolder(View itemView) {
        super(itemView);
        counterName = (TextView) itemView.findViewById(R.id.counter_name);
        counterValue = (TextView) itemView.findViewById(R.id.counter_value);
        minusButton = (ImageView) itemView.findViewById(R.id.minus_button);
        plusButton = (ImageView) itemView.findViewById(R.id.plus_button);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMinusButtonClicked();
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPlusButtonClicked();
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCounterClicked();
            }
        });
    }

    public void setListener(@Nullable OnCounterClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void setCounterName(String name) {
        counterName.setText(name);
    }

    @Override
    public void setCounterValue(int value) {
        counterValue.setText(String.valueOf(value));
    }

    @Override
    public void setMinusButtonEnabled(boolean enabled) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            minusButton.getDrawable().setTint(enabled ? Color.BLACK : Color.GRAY);
        }
        minusButton.setClickable(enabled);
    }

    @Override
    public void setPlusButtonEnabled(boolean enabled) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            plusButton.getDrawable().setTint(enabled ? Color.BLACK : Color.GRAY);
        }
        plusButton.setClickable(enabled);
    }

    @Override
    public void goToDetailView(Counter counter) {
        if (listener != null) {
            listener.onCounterClick(counter);
        }
    }

    public interface OnCounterClickListener {
        void onCounterClick(Counter counter);
    }
}
