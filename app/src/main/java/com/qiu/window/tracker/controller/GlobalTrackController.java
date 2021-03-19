package com.qiu.window.tracker.controller;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qiu.base.lib.utils.App;
import com.qiu.window.tracker.R;
import com.qiu.window.tracker.service.FloatingWindowService;

/**
 * 悬浮窗，控制跟踪/复现操作
 */
public class GlobalTrackController extends FloatingWindowService {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @NonNull
    @Override
    protected View createWindowView() {
        return App.i().getLayoutInflater().inflate(R.layout.window_floating, null, false);
    }

    @NonNull
    @Override
    protected SizeParams createSizeEntry() {
        return new SizeParams(100, 100, 0, 0);
    }

    public void startTrack() {

    }

    public void startSimulate() {

    }
}
