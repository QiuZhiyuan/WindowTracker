package com.qiu.window.tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accessibilityPermission(View view) {
        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
    }
}
