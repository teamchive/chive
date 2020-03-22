package android.support.v4.a;

import android.app.Activity;
import android.os.Build$VERSION;

public class a extends android.support.v4.b.a {
    public static void a(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 16) {
            arg2.finishAffinity();
        }
        else {
            arg2.finish();
        }
    }
}

