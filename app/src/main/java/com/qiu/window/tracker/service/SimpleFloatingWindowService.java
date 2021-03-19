package com.qiu.window.tracker.service;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class SimpleFloatingWindowService extends FloatingWindowService {
    @NonNull
    @Override
    protected View createWindowView() {
        final Button button = new Button(this);
        button.setText("Float window");
        button.setBackgroundColor(Color.GRAY);
        button.setOnClickListener(v -> button.setText("Hello!!!"));
        return button;
    }

    @Override
    protected void onWindowViewCreated(@NonNull View root) {

    }

    @Override
    protected int getRootViewLayoutId() {
        return 0;
    }

    @NonNull
    @Override
    protected SizeParams createSizeEntry() {
        return new SizeParams(200, 200, 300, 300);
    }
}
