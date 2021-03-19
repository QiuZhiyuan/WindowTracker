package com.qiu.window.tracker.service;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qiu.base.lib.tools.Logger;
import com.qiu.window.tracker.controller.ScheduleType;

public class AutoActionService extends AccessibilityService {

    @NonNull
    private static final String TAG = AutoActionService.class.getSimpleName();

    @Nullable
    private AccessibilityEvent mLastWindowStateChangedEvent;
    @NonNull
    private ScheduleType mScheduleType = ScheduleType.NORMAL;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final int eventType = event.getEventType();
        final String packageName = (String) event.getPackageName();
//        Log.d("qiuzhiyuan", "packageName:" + packageName + " eventType:" + eventType);
        Logger.d(TAG, "AccessibilityEvent:" + packageName + " eventType:" + eventType);
        switch (eventType) {
            case AccessibilityEvent.TYPE_ANNOUNCEMENT:
            case AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT:
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_END:
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
            case AccessibilityEvent.TYPE_TOUCH_INTERACTION_END:
            case AccessibilityEvent.TYPE_TOUCH_INTERACTION_START:
            case AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED:
            case AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED:
            case AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED:
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
            case AccessibilityEvent.TYPE_VIEW_HOVER_ENTER:
            case AccessibilityEvent.TYPE_VIEW_HOVER_EXIT:
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
            case AccessibilityEvent.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY:
            case AccessibilityEvent.TYPE_WINDOWS_CHANGED:
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                break;
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                mLastWindowStateChangedEvent = event;
                Logger.d(TAG, "window changed:" + event.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }
}
