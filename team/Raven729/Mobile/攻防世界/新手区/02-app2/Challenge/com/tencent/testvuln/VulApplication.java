package com.tencent.testvuln;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class VulApplication extends Application {
    private static Context a;

    public VulApplication() {
        super();
    }

    public static Context a() {
        return VulApplication.a;
    }

    public void onCreate() {
        super.onCreate();
        Log.d("TestVulApp", "VulApplication onCreate");
        VulApplication.a = this.getApplicationContext();
    }
}

