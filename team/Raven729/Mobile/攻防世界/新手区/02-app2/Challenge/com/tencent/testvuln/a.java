package com.tencent.testvuln;

import android.app.Activity;
import android.os.Bundle;

public class a extends Activity {
    public static String a;
    public static String b;
    private String c;

    static {
        a.a = "";
        a.b = "";
    }

    public a() {
        super();
        this.c = "BaseActivity";
    }

    protected void onCreate(Bundle arg1) {
        super.onCreate(arg1);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }
}

