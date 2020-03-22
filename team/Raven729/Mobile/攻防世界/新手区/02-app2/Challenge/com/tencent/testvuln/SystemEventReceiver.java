package com.tencent.testvuln;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SystemEventReceiver extends BroadcastReceiver {
    public SystemEventReceiver() {
        super();
    }

    public void onReceive(Context arg4, Intent arg5) {
        arg5.getAction();
        SharedPreferences v0 = arg4.getSharedPreferences("test", 0);
        v0.getString("ilil", "");
        v0.getString("lili", "");
    }
}

