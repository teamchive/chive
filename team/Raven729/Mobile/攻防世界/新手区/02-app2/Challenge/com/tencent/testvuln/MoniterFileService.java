package com.tencent.testvuln;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MoniterFileService extends Service {
    class com.tencent.testvuln.MoniterFileService$1 extends BroadcastReceiver {
        com.tencent.testvuln.MoniterFileService$1(MoniterFileService arg1) {
            this.a = arg1;
            super();
        }

        public void onReceive(Context arg3, Intent arg4) {
            long v0 = 1000;
            try {
                Thread.sleep(v0);
            }
            catch(InterruptedException v0_1) {
                v0_1.printStackTrace();
            }
        }
    }

    class com.tencent.testvuln.MoniterFileService$2 extends Handler {
        com.tencent.testvuln.MoniterFileService$2(MoniterFileService arg1) {
            this.a = arg1;
            super();
        }

        public void handleMessage(Message arg2) {
            switch(arg2.what) {
                case 0: {
                    this.a.a();
                    break;
                }
            }
        }
    }

    private long a;
    private String b;
    private String c;
    private c d;
    private c e;
    private BroadcastReceiver f;
    private Handler g;

    public MoniterFileService() {
        super();
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new com.tencent.testvuln.MoniterFileService$1(this);
        this.g = new com.tencent.testvuln.MoniterFileService$2(this);
    }

    static Handler a(MoniterFileService arg1) {
        return arg1.g;
    }

    public void a() {
        Intent v0 = new Intent("com.tencent.xplatform.launchdplugin2");
        Bundle v1 = new Bundle();
        v1.putString("packagename", "com.tencent.mobileqq111");
        v1.putString("processname", "com.tencent.mobileqq:tool123");
        v1.putBoolean("preload", false);
        v1.putBoolean("movesofile", false);
        v1.putString("activityname", "com.tencent.mobileqq.MainActivity");
        v1.putString("processname", "1.0");
        v0.putExtras(v1);
        this.sendBroadcast(v0);
    }

    public IBinder onBind(Intent arg2) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        IntentFilter v1 = new IntentFilter();
        v1.addAction(String.format("action.guid.got:%s", "com.tencent.wifimanager"));
        v1.addAction(String.format("action.rsa.got:%s", "com.tencent.wifimanager"));
        v1.addAction(String.format("action.reg.guid:%s", "com.tencent.wifimanager"));
        v1.addAction(String.format("action.up.rsa:%s", "com.tencent.wifimanager"));
        v1.addAction(String.format("action.d.a:%s", "com.tencent.wifimanager"));
        this.registerReceiver(this.f, v1);
        IntentFilter v0 = new IntentFilter();
        v0.addAction("com.tencent.testvul.service.MoniterFile");
        v0.setPriority(0x7FFFFFFF);
        this.registerReceiver(this.f, v0);
    }

    public void onDestroy() {
        Log.i("Test", "Service onDestroy--->");
        super.onDestroy();
    }

    public void onStart(Intent arg3, int arg4) {
        super.onStart(arg3, arg4);
        this.b = arg3.getStringExtra("ilil");
        this.c = arg3.getStringExtra("lili");
        new Thread() {
            public void run() {
                long v0 = 10000;
                try {
                    Thread.sleep(v0);
                }
                catch(InterruptedException v0_1) {
                    v0_1.printStackTrace();
                }

                Message v0_2 = new Message();
                v0_2.what = 0;
                MoniterFileService.a(this.a).sendMessage(v0_2);
            }
        }.start();
    }
}

