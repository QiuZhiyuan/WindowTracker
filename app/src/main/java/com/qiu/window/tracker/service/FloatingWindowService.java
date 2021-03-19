package com.qiu.window.tracker.service;

import static android.view.WindowManager.LayoutParams.*;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qiu.base.lib.tools.Logger;
import com.qiu.base.lib.utils.App;
import com.qiu.window.tracker.widget.DragOnTouchListener;

public abstract class FloatingWindowService extends Service implements
        DragOnTouchListener.TouchMoveListener {
    @NonNull
    private static final String TAG = FloatingWindowService.class.getSimpleName();

    protected static class SizeParams {
        public final int width;
        public final int height;
        public final int x;
        public final int y;

        public SizeParams(int width, int height, int x, int y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }
    }

    @NonNull
    private final Point mScreenSize = App.i().getScreenSize();
    @Nullable
    private View mFloatWindowView;
    @NonNull
    private final DragOnTouchListener mDragOnTouchListener = new DragOnTouchListener(this);
    private boolean mIsShowing;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Settings.canDrawOverlays(this) && !mIsShowing) {
            showFloatingWindow();
            mIsShowing = true;
        }
        Logger.d(TAG, mScreenSize.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideFloatingWindow();
    }

    protected void showFloatingWindow() {
        final WindowManager windowManager = getWindowManager();
        final View rootWindowView = getWindowView();
        final WindowManager.LayoutParams layoutParams = createLayoutParams();
        windowManager.addView(rootWindowView, layoutParams);
    }

    protected void hideFloatingWindow() {
        final WindowManager windowManager = getWindowManager();
        final View rootWindowView = getWindowView();
        windowManager.removeView(rootWindowView);
    }

    @NonNull
    private WindowManager getWindowManager() {
        return (WindowManager) getSystemService(WINDOW_SERVICE);
    }

    @NonNull
    private View getWindowView() {
        if (mFloatWindowView == null) {
            mFloatWindowView = createWindowView();
        }
        mFloatWindowView.setOnTouchListener(mDragOnTouchListener);
        return mFloatWindowView;
    }

    @NonNull
    protected WindowManager.LayoutParams createLayoutParams() {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        layoutParams.flags = FLAG_LAYOUT_NO_LIMITS | FLAG_NOT_TOUCH_MODAL | FLAG_LAYOUT_IN_SCREEN;
        layoutParams.format = PixelFormat.RGBA_8888;
        final SizeParams sizeParams = createSizeEntry();
        layoutParams.width = sizeParams.width;
        layoutParams.height = sizeParams.height;
        layoutParams.x = sizeParams.x;
        layoutParams.y = sizeParams.y;
        onLayoutParamsCreated(layoutParams);
        return layoutParams;
    }

    @Override
    public void onMove(int moveX, int moveY) {
        final WindowManager windowManager = getWindowManager();
        final View rootWindowView = getWindowView();
        final WindowManager.LayoutParams layoutParams =
                (WindowManager.LayoutParams) rootWindowView.getLayoutParams();
        layoutParams.x += moveX;
        layoutParams.y += moveY;
//        final int totalX = layoutParams.x + layoutParams.width;
//        final int totalY = layoutParams.y + layoutParams.height;
//
//        if (totalX > mScreenSize.x) {
//            layoutParams.x = mScreenSize.x - layoutParams.width;
//        }
        // TODO Compute if layoutParams.x is 0
//        if (layoutParams.x < 0) {
//            layoutParams.x = 0;
//        }
//        if (totalY > mScreenSize.y) {
//            layoutParams.y = mScreenSize.y - layoutParams.height;
//        }
//        if (layoutParams.y < 0) {
//            layoutParams.y = 0;
//        }
//        Logger.d(TAG, layoutParams.x + " " + layoutParams.y + " ");
        windowManager.updateViewLayout(rootWindowView, layoutParams);
    }

    @NonNull
    protected abstract View createWindowView();

    @NonNull
    protected abstract SizeParams createSizeEntry();

    protected void onLayoutParamsCreated(@NonNull WindowManager.LayoutParams layoutParams) {
    }
}
