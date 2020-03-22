package com.tencent.testvuln;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

public class TestRemoteService extends Service {
    class com.tencent.testvuln.TestRemoteService$1 extends a {
        com.tencent.testvuln.TestRemoteService$1(TestRemoteService arg1) {
            this.a = arg1;
            super();
        }

        public String a(String arg5, int arg6) {
            Log.d(TestRemoteService.a(), "called RemoteService someOperate()");
            SharedPreferences v0 = this.a.getSharedPreferences("test", 0);
            return v0.getString("ilil", "") + " " + v0.getString("lili", "");
        }
    }

    private static final String a;
    private final a b;

    static {
        TestRemoteService.a = TestRemoteService.class.getSimpleName();
    }

    public TestRemoteService() {
        super();
        this.b = new com.tencent.testvuln.TestRemoteService$1(this);
    }

    static String a() {
        return TestRemoteService.a;
    }

    public IBinder onBind(Intent arg2) {
        return this.b;
    }
}

