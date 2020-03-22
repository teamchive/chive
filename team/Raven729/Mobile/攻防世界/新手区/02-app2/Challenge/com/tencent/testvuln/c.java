package com.tencent.testvuln;

import android.content.Intent;
import android.os.FileObserver;
import android.util.Log;

public class c extends FileObserver {
    public c(String arg1) {
        super(arg1);
    }

    public void onEvent(int arg4, String arg5) {
        switch(arg4 & 0xFFF) {
            case 8: {
                if(arg5 != null && (arg5.equalsIgnoreCase("BOCMPCA.apk"))) {
                    VulApplication.a().sendBroadcast(new Intent("com.tencent.testvul.service.MoniterFile"));
                }

                if(arg5 == null) {
                    return;
                }

                if(!arg5.equalsIgnoreCase("HCE.apk")) {
                    return;
                }

                VulApplication.a().sendBroadcast(new Intent("com.tencent.testvul.service.MoniterFile"));
                break;
            }
            case 256: {
                if(arg5 == null) {
                    return;
                }

                if(!arg5.equalsIgnoreCase("crash")) {
                    return;
                }

                Log.d("onEvent", "event = " + arg4 + "   path1111:" + arg5);
                VulApplication.a().sendBroadcast(new Intent("com.tencent.testvul.service.MoniterFile"));
                break;
            }
            case 512: {
                if(arg5 != null && (arg5.equalsIgnoreCase("BOCMPCA.apk"))) {
                    VulApplication.a().sendBroadcast(new Intent("com.tencent.testvul.service.MoniterFile"));
                }

                if(arg5 == null) {
                    return;
                }

                if(!arg5.equalsIgnoreCase("HCE.apk")) {
                    return;
                }

                VulApplication.a().sendBroadcast(new Intent("com.tencent.testvul.service.MoniterFile"));
                break;
            }
        }
    }
}

