package com.flyme.moyu.myapplication;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2015/8/30.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger
                .init("TAG")               // default PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .hideThreadInfo()             // default shown
                .setLogLevel(LogLevel.NONE) // default LogLevel.FULL
                .setMethodOffset(2);         // default 0
    }
}
