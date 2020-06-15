package com.randy.commonlib;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * 伪代码
 * 观察者 增加一双眼睛   被观察者 100个Activity看（生命周期函数）
 *
 * @author randy
 */
public class GpsEngine implements DefaultLifecycleObserver {

    private static GpsEngine gpsEngine;

    public static GpsEngine getInstance() {
        if (gpsEngine == null) {
            synchronized (GpsEngine.class) {
                if (gpsEngine == null) {
                    gpsEngine = new GpsEngine();
                }
            }
        }
        return gpsEngine;
    }

    private boolean isActive;  // 开启Gps  关闭Gps

    public void setActive(boolean active) {
        isActive = active;
    }

    private void onResumeAction() {
        setActive(true);
        Log.d("Derry", "onResumeAction: open");
        // .......  1000行代码
    }

    private void onPauseAction() {
        setActive(false);
        Log.d("Derry", "onResumeAction: close");
        // .......  1000行代码
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        onResumeAction();
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        onPauseAction();
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }

}
