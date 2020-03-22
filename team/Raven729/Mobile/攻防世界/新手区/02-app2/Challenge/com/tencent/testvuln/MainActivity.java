package com.tencent.testvuln;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.testvuln.c.SignatureTool;

@SuppressLint(value={"ShowToast"}) public class MainActivity extends Activity implements View$OnClickListener {
    private Button a;
    private Handler b;
    private EditText c;
    private EditText d;

    public MainActivity() {
        super();
        this.b = null;
    }

    public void onClick(View arg6) {
        switch(arg6.getId()) {
            case 2131165187: {
                if(this.c.getText().length() != 0 && this.d.getText().length() != 0) {
                    String v0 = this.c.getText().toString();
                    String v1 = this.d.getText().toString();
                    Log.e("test", v0 + " test2 = " + v1);
                    Intent v2 = new Intent(((Context)this), SecondActivity.class);
                    v2.putExtra("ili", v0);
                    v2.putExtra("lil", v1);
                    this.startActivity(v2);
                    return;
                }

                Toast.makeText(((Context)this), "不能为空", 1).show();
                break;
            }
        }
    }

    protected void onCreate(Bundle arg5) {
        super.onCreate(arg5);
        this.setContentView(0x7F030000);
        this.a = this.findViewById(0x7F070003);
        this.a.setOnClickListener(((View$OnClickListener)this));
        this.c = this.findViewById(0x7F070001);
        this.d = this.findViewById(0x7F070002);
        SharedPreferences$Editor v0 = this.getSharedPreferences("test", 0).edit();
        v0.putLong("ili", System.currentTimeMillis());
        v0.commit();
        Log.d("hashcode", SignatureTool.getSignature(((Context)this)) + "");
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

