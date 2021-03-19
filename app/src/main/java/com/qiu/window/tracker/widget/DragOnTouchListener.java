package com.qiu.window.tracker.widget;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class DragOnTouchListener implements View.OnTouchListener {

    public interface TouchMoveListener {
        public void onMove(int moveX, int moveY);
    }

    private int mStartX;
    private int mStartY;
    @NonNull
    private final TouchMoveListener mTouchMoveListener;

    public DragOnTouchListener(@NonNull TouchMoveListener listener) {
        mTouchMoveListener = listener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = (int) event.getRawX();
                mStartY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                final int moveX = x - mStartX;
                final int moveY = y - mStartY;
                mStartX = x;
                mStartY = y;
                mTouchMoveListener.onMove(moveX, moveY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}
