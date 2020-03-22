package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class b extends l implements DialogInterface {
    public class a {
        private final android.support.v7.app.AlertController$a a;
        private final int b;

        public a(Context arg2) {
            this(arg2, b.a(arg2, 0));
        }

        public a(Context arg4, int arg5) {
            super();
            this.a = new android.support.v7.app.AlertController$a(new ContextThemeWrapper(arg4, b.a(arg4, arg5)));
            this.b = arg5;
        }

        public Context a() {
            return this.a.a;
        }

        public a a(DialogInterface$OnKeyListener arg2) {
            this.a.r = arg2;
            return this;
        }

        public a a(Drawable arg2) {
            this.a.d = arg2;
            return this;
        }

        public a a(View arg2) {
            this.a.g = arg2;
            return this;
        }

        public a a(ListAdapter arg2, DialogInterface$OnClickListener arg3) {
            this.a.t = arg2;
            this.a.u = arg3;
            return this;
        }

        public a a(CharSequence arg2) {
            this.a.f = arg2;
            return this;
        }

        public b b() {
            b v0 = new b(this.a.a, this.b);
            this.a.a(v0.a);
            v0.setCancelable(this.a.o);
            if(this.a.o) {
                v0.setCanceledOnTouchOutside(true);
            }

            v0.setOnCancelListener(this.a.p);
            v0.setOnDismissListener(this.a.q);
            if(this.a.r != null) {
                v0.setOnKeyListener(this.a.r);
            }

            return v0;
        }
    }

    final AlertController a;

    protected b(Context arg4, int arg5) {
        super(arg4, b.a(arg4, arg5));
        this.a = new AlertController(this.getContext(), ((l)this), this.getWindow());
    }

    static int a(Context arg4, int arg5) {
        if((arg5 >>> 24 & 0xFF) < 1) {
            TypedValue v0 = new TypedValue();
            arg4.getTheme().resolveAttribute(android.support.v7.a.a$a.alertDialogTheme, v0, true);
            arg5 = v0.resourceId;
        }

        return arg5;
    }

    protected void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        this.a.a();
    }

    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        boolean v0 = this.a.a(arg2, arg3) ? true : super.onKeyDown(arg2, arg3);
        return v0;
    }

    public boolean onKeyUp(int arg2, KeyEvent arg3) {
        boolean v0 = this.a.b(arg2, arg3) ? true : super.onKeyUp(arg2, arg3);
        return v0;
    }

    public void setTitle(CharSequence arg2) {
        super.setTitle(arg2);
        this.a.a(arg2);
    }
}

