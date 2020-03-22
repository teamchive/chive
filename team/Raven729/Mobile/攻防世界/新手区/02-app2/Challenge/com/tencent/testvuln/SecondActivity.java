package com.tencent.testvuln;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.testvuln.c.Encryto;

public class SecondActivity extends a {
    class com.tencent.testvuln.SecondActivity$1 extends BroadcastReceiver {
        com.tencent.testvuln.SecondActivity$1(SecondActivity arg1) {
            this.a = arg1;
            super();
        }

        public void onReceive(Context arg3, Intent arg4) {
            Toast.makeText(arg3, "myReceiver receive", 0).show();
            arg3.getPackageName().equals(arg4.getAction());
        }
    }

    private BroadcastReceiver c;

    public SecondActivity() {
        super();
        this.c = new com.tencent.testvuln.SecondActivity$1(this);
    }

    protected void onCreate(Bundle arg6) {
        super.onCreate(arg6);
        this.setContentView(0x7F030001);
        Intent v0 = this.getIntent();
        String v1 = v0.getStringExtra("ili");
        String v2 = v0.getStringExtra("lil");
        if(Encryto.doRawData(this, v1 + v2).equals("VEIzd/V2UPYNdn/bxH3Xig==")) {
            v0.setAction("android.test.action.MoniterInstallService");
            v0.setClass(((Context)this), MoniterInstallService.class);
            v0.putExtra("company", "tencent");
            v0.putExtra("name", "hacker");
            v0.putExtra("age", 18);
            this.startActivity(v0);
            this.startService(v0);
        }

        SharedPreferences$Editor v0_1 = this.getSharedPreferences("test", 0).edit();
        v0_1.putString("ilil", v1);
        v0_1.putString("lili", v2);
        v0_1.commit();
    }

    public boolean onCreateOptionsMenu(Menu arg3) {
        this.getMenuInflater().inflate(0x7F060000, arg3);
        return 1;
    }

    public boolean onOptionsItemSelected(MenuItem arg3) {
        boolean v0 = arg3.getItemId() == 0x7F070004 ? true : super.onOptionsItemSelected(arg3);
        return v0;
    }
}

