package com.qiu.window.tracker.controller;

import androidx.annotation.NonNull;

public class ControlHelper {

    private volatile static ControlHelper sInstance;

    @NonNull
    public static ControlHelper i() {
        if (sInstance == null) {
            synchronized (ControlHelper.class) {
                if (sInstance == null) {
                    sInstance = new ControlHelper();
                }
            }
        }
        return sInstance;
    }

    private ControlHelper() {
    }
}
