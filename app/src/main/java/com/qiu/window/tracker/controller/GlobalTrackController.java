package com.qiu.window.tracker.controller;

import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qiu.window.tracker.R;
import com.qiu.window.tracker.service.FloatingWindowService;

/**
 * 悬浮窗，控制跟踪/复现操作
 */
public class GlobalTrackController extends FloatingWindowService implements View.OnClickListener {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onWindowViewCreated(@NonNull View root) {
        final View startTracker = root.findViewById(R.id.start_tracker);
        startTracker.setOnClickListener(this);
        final View startSimulator = root.findViewById(R.id.start_simulator);
        startSimulator.setOnClickListener(this);
    }

    @Override
    protected int getRootViewLayoutId() {
        return R.layout.layout_floating_window;
    }

    @NonNull
    @Override
    protected SizeParams createSizeEntry() {
        return new SizeParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT, 0, 0);
    }

    public void startTrack() {

    }

    public void startSimulate() {

    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.start_tracker:
                break;
            case R.id.start_simulator:
                break;
        }
    }
}
