package com.qiu.window.tracker.service.event;

import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.NonNull;

public abstract class AbsAccessibilityEvent {
    @NonNull
    private final String mPackageName;
    @NonNull
    private final AccessibilityEvent mEvent;

    protected AbsAccessibilityEvent(@NonNull AccessibilityEvent event) {
        mPackageName = (String) event.getPackageName();
        mEvent = event;
    }

    @NonNull
    public String getPackageName() {
        return mPackageName;
    }
}
