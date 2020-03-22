package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.g.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

public class i extends f {
    class android.support.v4.a.i$1 extends Handler {
        android.support.v4.a.i$1(i arg1) {
            this.a = arg1;
            super();
        }

        public void handleMessage(Message arg3) {
            switch(arg3.what) {
                case 1: {
                    if(!this.a.g) {
                        return;
                    }

                    this.a.a(false);
                    break;
                }
                case 2: {
                    this.a.b();
                    this.a.d.n();
                    break;
                }
                default: {
                    super.handleMessage(arg3);
                    break;
                }
            }
        }
    }

    class a extends l {
        public a(i arg1) {
            this.a = arg1;
            super(arg1);
        }

        public View a(int arg2) {
            return this.a.findViewById(arg2);
        }

        public void a(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
            this.a.dump(arg2, arg3, arg4, arg5);
        }

        public boolean a() {
            Window v0 = this.a.getWindow();
            boolean v0_1 = v0 == null || v0.peekDecorView() == null ? false : true;
            return v0_1;
        }

        public boolean a(h arg2) {
            boolean v0 = !this.a.isFinishing() ? true : false;
            return v0;
        }

        public LayoutInflater b() {
            return this.a.getLayoutInflater().cloneInContext(this.a);
        }

        public void b(h arg2) {
            this.a.a(arg2);
        }

        public void c() {
            this.a.d();
        }

        public boolean d() {
            boolean v0 = this.a.getWindow() != null ? true : false;
            return v0;
        }

        public int e() {
            Window v0 = this.a.getWindow();
            int v0_1 = v0 == null ? 0 : v0.getAttributes().windowAnimations;
            return v0_1;
        }
    }

    final class b {
        Object a;
        o b;
        k c;

        b() {
            super();
        }
    }

    final Handler c;
    final android.support.v4.a.k d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    int j;
    android.support.v4.g.l k;

    public i() {
        super();
        this.c = new android.support.v4.a.i$1(this);
        this.d = android.support.v4.a.k.a(new a(this));
        this.g = true;
        this.h = true;
    }

    private static void a(m arg3, android.arch.lifecycle.b$b arg4) {
        Iterator v1 = arg3.b().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((h)v0).U.a(arg4);
            i.a(((h)v0).g(), arg4);
        }
    }

    public android.arch.lifecycle.b a() {
        return super.a();
    }

    final View a(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return this.d.a(arg2, arg3, arg4, arg5);
    }

    public void a(h arg1) {
    }

    void a(boolean arg3) {
        if(!this.h) {
            this.h = true;
            this.i = arg3;
            this.c.removeMessages(1);
            this.e();
        }
        else if(arg3) {
            this.d.o();
            this.d.c(true);
        }
    }

    protected boolean a(View arg2, Menu arg3) {
        return super.onPreparePanel(0, arg2, arg3);
    }

    protected void b() {
        this.d.h();
    }

    public Object c() {
        return null;
    }

    @Deprecated public void d() {
        this.invalidateOptionsMenu();
    }

    public void dump(String arg3, FileDescriptor arg4, PrintWriter arg5, String[] arg6) {
        super.dump(arg3, arg4, arg5, arg6);
        arg5.print(arg3);
        arg5.print("Local FragmentActivity ");
        arg5.print(Integer.toHexString(System.identityHashCode(this)));
        arg5.println(" State:");
        String v0 = arg3 + "  ";
        arg5.print(v0);
        arg5.print("mCreated=");
        arg5.print(this.e);
        arg5.print("mResumed=");
        arg5.print(this.f);
        arg5.print(" mStopped=");
        arg5.print(this.g);
        arg5.print(" mReallyStopped=");
        arg5.println(this.h);
        this.d.a(v0, arg4, arg5, arg6);
        this.d.a().a(arg3, arg4, arg5, arg6);
    }

    void e() {
        this.d.c(this.i);
        this.d.k();
    }

    public m f() {
        return this.d.a();
    }

    protected void onActivityResult(int arg5, int arg6, Intent arg7) {
        this.d.b();
        int v0 = arg5 >> 16;
        if(v0 != 0) {
            int v1 = v0 - 1;
            Object v0_1 = this.k.a(v1);
            this.k.c(v1);
            if(v0_1 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            }
            else {
                h v1_1 = this.d.a(((String)v0_1));
                if(v1_1 == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for who: " + (((String)v0_1)));
                }
                else {
                    v1_1.a(0xFFFF & arg5, arg6, arg7);
                }
            }
        }
        else {
            super.onActivityResult(arg5, arg6, arg7);
        }
    }

    public void onBackPressed() {
        m v0 = this.d.a();
        boolean v1 = v0.c();
        if((!v1 || Build$VERSION.SDK_INT > 25) && ((v1) || !v0.a())) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        this.d.a(arg2);
    }

    protected void onCreate(Bundle arg8) {
        h v1 = null;
        this.d.a(v1);
        super.onCreate(arg8);
        Object v0 = this.getLastNonConfigurationInstance();
        if(v0 != null) {
            this.d.a(((b)v0).c);
        }

        if(arg8 != null) {
            Parcelable v3 = arg8.getParcelable("android:support:fragments");
            android.support.v4.a.k v4 = this.d;
            o v0_1 = v0 != null ? ((b)v0).b : ((o)v1);
            v4.a(v3, v0_1);
            if(!arg8.containsKey("android:support:next_request_index")) {
                goto label_35;
            }

            this.j = arg8.getInt("android:support:next_request_index");
            int[] v1_1 = arg8.getIntArray("android:support:request_indicies");
            String[] v3_1 = arg8.getStringArray("android:support:request_fragment_who");
            if(v1_1 != null && v3_1 != null && v1_1.length == v3_1.length) {
                this.k = new android.support.v4.g.l(v1_1.length);
                int v0_2 = 0;
                while(true) {
                    if(v0_2 < v1_1.length) {
                        this.k.b(v1_1[v0_2], v3_1[v0_2]);
                        ++v0_2;
                        continue;
                    }
                    else {
                        goto label_35;
                    }
                }
            }

            Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        }

    label_35:
        if(this.k == null) {
            this.k = new android.support.v4.g.l();
            this.j = 0;
        }

        this.d.e();
    }

    public boolean onCreatePanelMenu(int arg4, Menu arg5) {
        int v0;
        if(arg4 == 0) {
            v0 = super.onCreatePanelMenu(arg4, arg5) | this.d.a(arg5, this.getMenuInflater());
        }
        else {
            boolean v0_1 = super.onCreatePanelMenu(arg4, arg5);
        }

        return ((boolean)v0);
    }

    public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return super.onCreateView(arg2, arg3, arg4, arg5);
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return super.onCreateView(arg2, arg3, arg4);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a(false);
        this.d.l();
        this.d.p();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    public boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        boolean v0;
        if(super.onMenuItemSelected(arg2, arg3)) {
            v0 = true;
        }
        else {
            switch(arg2) {
                case 0: {
                    goto label_7;
                }
                case 6: {
                    goto label_10;
                }
            }

            return false;
        label_7:
            return this.d.a(arg3);
        label_10:
            v0 = this.d.b(arg3);
        }

        return v0;
    }

    public void onMultiWindowModeChanged(boolean arg2) {
        this.d.a(arg2);
    }

    protected void onNewIntent(Intent arg2) {
        super.onNewIntent(arg2);
        this.d.b();
    }

    public void onPanelClosed(int arg2, Menu arg3) {
        switch(arg2) {
            case 0: {
                this.d.b(arg3);
                break;
            }
        }

        super.onPanelClosed(arg2, arg3);
    }

    protected void onPause() {
        int v1 = 2;
        super.onPause();
        this.f = false;
        if(this.c.hasMessages(v1)) {
            this.c.removeMessages(v1);
            this.b();
        }

        this.d.i();
    }

    public void onPictureInPictureModeChanged(boolean arg2) {
        this.d.b(arg2);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        this.b();
        this.d.n();
    }

    public boolean onPreparePanel(int arg3, View arg4, Menu arg5) {
        boolean v0_1;
        if(arg3 != 0 || arg5 == null) {
            v0_1 = super.onPreparePanel(arg3, arg4, arg5);
        }
        else {
            int v0 = this.a(arg4, arg5) | this.d.a(arg5);
        }

        return v0_1;
    }

    public void onRequestPermissionsResult(int arg5, String[] arg6, int[] arg7) {
        int v3 = 0xFFFF;
        int v0 = arg5 >> 16 & v3;
        if(v0 != 0) {
            int v1 = v0 - 1;
            Object v0_1 = this.k.a(v1);
            this.k.c(v1);
            if(v0_1 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            }
            else {
                h v1_1 = this.d.a(((String)v0_1));
                if(v1_1 == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for who: " + (((String)v0_1)));
                }
                else {
                    v1_1.a(arg5 & v3, arg6, arg7);
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.n();
    }

    public final Object onRetainNonConfigurationInstance() {
        Object v0;
        if(this.g) {
            this.a(true);
        }

        Object v1 = this.c();
        o v2 = this.d.d();
        k v3 = this.d.r();
        if(v2 != null || v3 != null || v1 != null) {
            b v0_1 = new b();
            v0_1.a = v1;
            v0_1.b = v2;
            v0_1.c = v3;
        }
        else {
            v0 = null;
        }

        return v0;
    }

    protected void onSaveInstanceState(Bundle arg5) {
        super.onSaveInstanceState(arg5);
        i.a(this.f(), android.arch.lifecycle.b$b.c);
        Parcelable v0 = this.d.c();
        if(v0 != null) {
            arg5.putParcelable("android:support:fragments", v0);
        }

        if(this.k.b() > 0) {
            arg5.putInt("android:support:next_request_index", this.j);
            int[] v2 = new int[this.k.b()];
            String[] v3 = new String[this.k.b()];
            int v1;
            for(v1 = 0; v1 < this.k.b(); ++v1) {
                v2[v1] = this.k.d(v1);
                v3[v1] = this.k.e(v1);
            }

            arg5.putIntArray("android:support:request_indicies", v2);
            arg5.putStringArray("android:support:request_fragment_who", v3);
        }
    }

    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if(!this.e) {
            this.e = true;
            this.d.f();
        }

        this.d.b();
        this.d.n();
        this.d.o();
        this.d.g();
        this.d.q();
    }

    public void onStateNotSaved() {
        this.d.b();
    }

    protected void onStop() {
        super.onStop();
        this.g = true;
        i.a(this.f(), android.arch.lifecycle.b$b.c);
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public void startActivityForResult(Intent arg2, int arg3) {
        if(!this.b && arg3 != -1) {
            i.a(arg3);
        }

        super.startActivityForResult(arg2, arg3);
    }

    public void startActivityForResult(Intent arg1, int arg2, Bundle arg3) {
        super.startActivityForResult(arg1, arg2, arg3);
    }

    public void startIntentSenderForResult(IntentSender arg1, int arg2, Intent arg3, int arg4, int arg5, int arg6) {
        super.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void startIntentSenderForResult(IntentSender arg1, int arg2, Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) {
        super.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

