package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class g extends Fragment {
    interface a {
        void a();

        void b();

        void c();
    }

    private a a;

    public g() {
        super();
    }

    public static void a(Activity arg4) {
        FragmentManager v0 = arg4.getFragmentManager();
        if(v0.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            v0.beginTransaction().add(new g(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            v0.executePendingTransactions();
        }
    }

    private void a(android.arch.lifecycle.b$a arg3) {
        Activity v0 = this.getActivity();
        if((v0 instanceof e)) {
            ((e)v0).b().a(arg3);
        }
        else if((v0 instanceof c)) {
            b v0_1 = ((c)v0).a();
            if((v0_1 instanceof d)) {
                ((d)v0_1).a(arg3);
            }
        }
    }

    private void a(a arg1) {
        if(arg1 != null) {
            arg1.a();
        }
    }

    private void b(a arg1) {
        if(arg1 != null) {
            arg1.b();
        }
    }

    private void c(a arg1) {
        if(arg1 != null) {
            arg1.c();
        }
    }

    public void onActivityCreated(Bundle arg2) {
        super.onActivityCreated(arg2);
        this.a(this.a);
        this.a(android.arch.lifecycle.b$a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        this.a(android.arch.lifecycle.b$a.ON_DESTROY);
        this.a = null;
    }

    public void onPause() {
        super.onPause();
        this.a(android.arch.lifecycle.b$a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.c(this.a);
        this.a(android.arch.lifecycle.b$a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        this.b(this.a);
        this.a(android.arch.lifecycle.b$a.ON_START);
    }

    public void onStop() {
        super.onStop();
        this.a(android.arch.lifecycle.b$a.ON_STOP);
    }
}

