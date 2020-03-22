package com.tencent.testvuln;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MoniterInstallService extends Service {
    class com.tencent.testvuln.MoniterInstallService$1 extends BroadcastReceiver {
        com.tencent.testvuln.MoniterInstallService$1(MoniterInstallService arg1) {
            this.a = arg1;
            super();
        }

        public void onReceive(Context arg4, Intent arg5) {
            this.a.b("");
            long v0 = 1000;
            try {
                Thread.sleep(v0);
            }
            catch(InterruptedException v0_1) {
                v0_1.printStackTrace();
            }

            Intent v0_2 = new Intent("android.setting.word");
            v0_2.putExtra("1", MoniterInstallService.a(this.a));
            v0_2.putExtra("2", MoniterInstallService.b(this.a));
            arg4.sendBroadcast(v0_2);
        }
    }

    class com.tencent.testvuln.MoniterInstallService$2 extends Handler {
        com.tencent.testvuln.MoniterInstallService$2(MoniterInstallService arg1) {
            this.a = arg1;
            super();
        }

        public void handleMessage(Message arg3) {
            switch(arg3.what) {
                case 0: {
                    this.a.a("");
                    break;
                }
            }
        }
    }

    private long a;
    private String b;
    private String c;
    private c d;
    private BroadcastReceiver e;
    private Handler f;

    public MoniterInstallService() {
        super();
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = new com.tencent.testvuln.MoniterInstallService$1(this);
        this.f = new com.tencent.testvuln.MoniterInstallService$2(this);
    }

    static String a(MoniterInstallService arg1) {
        return arg1.b;
    }

    void a(String arg3) {
        String v0 = Environment.getExternalStorageDirectory().getPath() + "/crash/";
        if(this.d == null) {
            this.d = new c(v0);
        }

        this.d.startWatching();
    }

    static String b(MoniterInstallService arg1) {
        return arg1.c;
    }

    void b(String arg2) {
        if(this.d != null) {
            this.d.stopWatching();
        }
    }

    static Handler c(MoniterInstallService arg1) {
        return arg1.f;
    }

    public IBinder onBind(Intent arg2) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        IntentFilter v0 = new IntentFilter();
        v0.addAction("com.tencent.testvul.service.MoniterFile");
        v0.setPriority(0x7FFFFFFF);
        this.registerReceiver(this.e, v0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart(Intent arg3, int arg4) {
        super.onStart(arg3, arg4);
        this.b = arg3.getStringExtra("ili");
        this.c = arg3.getStringExtra("lil");
        new Thread() {
            public void run() {
                Message v0 = new Message();
                v0.what = 0;
                MoniterInstallService.c(this.a).sendMessage(v0);
            }
        }.start();
    }
}

