package com.a.easyjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.c;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends c {
    public MainActivity() {
        super();
    }

    private static char a(String arg1, b arg2, a arg3) {
        return arg3.a(arg2.a(arg1));
    }

    static Boolean a(String arg1) {
        return MainActivity.b(arg1);
    }

    private static Boolean b(String arg8) {
        Boolean v0_1;
        int v0 = 0;
        if(!arg8.startsWith("flag{")) {
            v0_1 = Boolean.valueOf(false);
        }
        else if(!arg8.endsWith("}")) {
            v0_1 = Boolean.valueOf(false);
        }
        else {
            String v2 = arg8.substring(5, arg8.length() - 1);
            b v4 = new b(Integer.valueOf(2));
            a v5 = new a(Integer.valueOf(3));
            StringBuilder v3 = new StringBuilder();
            int v1 = 0;
            while(v0 < v2.length()) {
                v3.append(MainActivity.a(v2.charAt(v0) + "", v4, v5));
                Integer v6 = Integer.valueOf(v4.b().intValue() / 25);
                if(v6.intValue() > v1 && v6.intValue() >= 1) {
                    ++v1;
                }

                ++v0;
            }

            v0_1 = Boolean.valueOf(v3.toString().equals("wigwrkaugala"));
        }

        return v0_1;
    }

    protected void onCreate(Bundle arg3) {
        super.onCreate(arg3);
        this.setContentView(0x7F04001B);
        this.findViewById(0x7F0B0076).setOnClickListener(new View$OnClickListener(((Context)this)) {
            public void onClick(View arg5) {
                if(MainActivity.a(this.a.findViewById(0x7F0B0075).getText().toString()).booleanValue()) {
                    Toast.makeText(this.a, "You are right!", 1).show();
                }
                else {
                    Toast.makeText(this.a, "You are wrong! Bye~", 1).show();
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            System.exit(1);
                        }
                    }, 2000);
                }
            }
        });
    }
}

