package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.support.v7.view.d;
import android.support.v7.widget.aa;
import android.support.v7.widget.at;
import android.support.v7.widget.f;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.support.v7.widget.j;
import android.support.v7.widget.n;
import android.support.v7.widget.p;
import android.support.v7.widget.q;
import android.support.v7.widget.t;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.support.v7.widget.x;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View$OnClickListener;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class m {
    class a implements View$OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View arg1, String arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
        }

        private void a(Context arg7, String arg8) {
            Context v0;
            for(v0 = arg7; v0 != null; v0 = null) {
                try {
                    if(v0.isRestricted()) {
                        goto label_17;
                    }

                    Method v1_1 = v0.getClass().getMethod(this.b, View.class);
                    if(v1_1 == null) {
                        goto label_17;
                    }

                    this.c = v1_1;
                    this.d = v0;
                    return;
                }
                catch(NoSuchMethodException v1) {
                }

            label_17:
                if((v0 instanceof ContextWrapper)) {
                    v0 = ((ContextWrapper)v0).getBaseContext();
                    continue;
                }
            }

            int v0_1 = this.a.getId();
            String v0_2 = v0_1 == -1 ? "" : " with id \'" + this.a.getContext().getResources().getResourceEntryName(v0_1) + "\'";
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.a.getClass() + v0_2);
        }

        public void onClick(View arg5) {
            if(this.c == null) {
                this.a(this.a.getContext(), this.b);
            }

            try {
                this.c.invoke(this.d, arg5);
                return;
            }
            catch(InvocationTargetException v0) {
                throw new IllegalStateException("Could not execute method for android:onClick", ((Throwable)v0));
            }
            catch(IllegalAccessException v0_1) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", ((Throwable)v0_1));
            }
        }
    }

    private static final Class[] a;
    private static final int[] b;
    private static final String[] c;
    private static final Map d;
    private final Object[] e;

    static {
        m.a = new Class[]{Context.class, AttributeSet.class};
        m.b = new int[]{0x101026F};
        m.c = new String[]{"android.widget.", "android.view.", "android.webkit."};
        m.d = new android.support.v4.g.a();
    }

    m() {
        super();
        this.e = new Object[2];
    }

    public final View a(View arg5, String arg6, Context arg7, AttributeSet arg8, boolean arg9, boolean arg10, boolean arg11, boolean arg12) {
        View v0_1;
        x v1_12;
        Context v0 = !arg9 || arg5 == null ? arg7 : arg5.getContext();
        if((arg10) || (arg11)) {
            v0 = m.a(v0, arg8, arg10, arg11);
        }

        if(arg12) {
            v0 = at.a(v0);
        }

        aa v1 = null;
        int v2 = -1;
        switch(arg6.hashCode()) {
            case 1413872058: {
                if(!arg6.equals("AutoCompleteTextView")) {
                    goto label_12;
                }

                v2 = 9;
                break;
            }
            case 1666676343: {
                if(!arg6.equals("EditText")) {
                    goto label_12;
                }

                v2 = 3;
                break;
            }
            case 2001146706: {
                if(!arg6.equals("Button")) {
                    goto label_12;
                }

                v2 = 2;
                break;
            }
            case -1946472170: {
                if(!arg6.equals("RatingBar")) {
                    goto label_12;
                }

                v2 = 11;
                break;
            }
            case -1455429095: {
                if(!arg6.equals("CheckedTextView")) {
                    goto label_12;
                }

                v2 = 8;
                break;
            }
            case -1346021293: {
                if(!arg6.equals("MultiAutoCompleteTextView")) {
                    goto label_12;
                }

                v2 = 10;
                break;
            }
            case -938935918: {
                if(!arg6.equals("TextView")) {
                    goto label_12;
                }

                v2 = 0;
                break;
            }
            case -937446323: {
                if(!arg6.equals("ImageButton")) {
                    goto label_12;
                }

                v2 = 5;
                break;
            }
            case -658531749: {
                if(!arg6.equals("SeekBar")) {
                    goto label_12;
                }

                v2 = 12;
                break;
            }
            case -339785223: {
                if(!arg6.equals("Spinner")) {
                    goto label_12;
                }

                v2 = 4;
                break;
            }
            case 776382189: {
                if(!arg6.equals("RadioButton")) {
                    goto label_12;
                }

                v2 = 7;
                break;
            }
            case 1125864064: {
                if(!arg6.equals("ImageView")) {
                    goto label_12;
                }

                v2 = 1;
                break;
            }
            case 1601505219: {
                if(!arg6.equals("CheckBox")) {
                    goto label_12;
                }

                v2 = 6;
                break;
            }
        }

    label_12:
        switch(v2) {
            case 0: {
                v1 = new aa(v0, arg8);
                break;
            }
            case 1: {
                p v1_8 = new p(v0, arg8);
                break;
            }
            case 2: {
                h v1_10 = new h(v0, arg8);
                break;
            }
            case 3: {
                android.support.v7.widget.m v1_11 = new android.support.v7.widget.m(v0, arg8);
                break;
            }
            case 4: {
                v1_12 = new x(v0, arg8);
                break;
            }
            case 5: {
                n v1_1 = new n(v0, arg8);
                break;
            }
            case 6: {
                i v1_2 = new i(v0, arg8);
                break;
            }
            case 7: {
                t v1_3 = new t(v0, arg8);
                break;
            }
            case 8: {
                j v1_4 = new j(v0, arg8);
                break;
            }
            case 9: {
                f v1_5 = new f(v0, arg8);
                break;
            }
            case 10: {
                q v1_6 = new q(v0, arg8);
                break;
            }
            case 11: {
                u v1_7 = new u(v0, arg8);
                break;
            }
            case 12: {
                v v1_9 = new v(v0, arg8);
                break;
            }
        }

        if((((aa)v1_12)) != null || arg7 == v0) {
            aa v0_2 = ((aa)v1_12);
        }
        else {
            v0_1 = this.a(v0, arg6, arg8);
        }

        if(v0_1 != null) {
            this.a(v0_1, arg8);
        }

        return v0_1;
    }

    private static Context a(Context arg4, AttributeSet arg5, boolean arg6, boolean arg7) {
        d v4;
        TypedArray v2 = arg4.obtainStyledAttributes(arg5, android.support.v7.a.a$j.View, 0, 0);
        int v0 = arg6 ? v2.getResourceId(android.support.v7.a.a$j.View_android_theme, 0) : 0;
        if((arg7) && v0 == 0) {
            v0 = v2.getResourceId(android.support.v7.a.a$j.View_theme, 0);
            if(v0 != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }

        int v1 = v0;
        v2.recycle();
        if(v1 != 0 && (!(arg4 instanceof d) || arg4.a() != v1)) {
            v4 = new d(arg4, v1);
        }

        return ((Context)v4);
    }

    private View a(Context arg6, String arg7, AttributeSet arg8) {
        View v0_2;
        int v2;
        String v1 = null;
        if(arg7.equals("view")) {
            arg7 = arg8.getAttributeValue(v1, "class");
        }

        try {
            this.e[0] = arg6;
            this.e[1] = arg8;
            if(-1 != arg7.indexOf(46)) {
                goto label_40;
            }

            v2 = 0;
            while(true) {
            label_19:
                if(v2 >= m.c.length) {
                    goto label_34;
                }

                v0_2 = this.a(arg6, arg7, m.c[v2]);
                if(v0_2 == null) {
                    goto label_31;
                }

                break;
            }
        }
        catch(Throwable v0) {
            goto label_56;
        }
        catch(Exception v0_1) {
            goto label_49;
        }

        this.e[0] = v1;
        this.e[1] = v1;
        return v0_2;
    label_31:
        ++v2;
        goto label_19;
    label_34:
        this.e[0] = v1;
        this.e[1] = v1;
        return ((View)v1);
    label_40:
        String v0_3 = null;
        try {
            v0_2 = this.a(arg6, arg7, v0_3);
        }
        catch(Throwable v0) {
        label_56:
            this.e[0] = v1;
            this.e[1] = v1;
            throw v0;
        }
        catch(Exception v0_1) {
        label_49:
            this.e[0] = v1;
            this.e[1] = v1;
            return ((View)v1);
        }

        this.e[0] = v1;
        this.e[1] = v1;
        return v0_2;
    }

    private View a(Context arg3, String arg4, String arg5) {
        View v0_4;
        String v0_2;
        ClassLoader v1;
        Object v0 = m.d.get(arg4);
        if(v0 == null) {
            try {
                v1 = arg3.getClassLoader();
                if(arg5 != null) {
                    v0_2 = arg5 + arg4;
                }
                else {
                    goto label_22;
                }

                goto label_10;
            }
            catch(Exception v0_1) {
                goto label_25;
            }

        label_22:
            v0_2 = arg4;
            try {
            label_10:
                Constructor v0_3 = v1.loadClass(v0_2).asSubclass(View.class).getConstructor(m.a);
                m.d.put(arg4, v0_3);
            label_17:
                v0_3.setAccessible(true);
                v0 = v0_3.newInstance(this.e);
            }
            catch(Exception v0_1) {
            label_25:
                v0_4 = null;
            }
        }
        else {
            goto label_17;
        }

        return v0_4;
    }

    private void a(View arg4, AttributeSet arg5) {
        Context v0 = arg4.getContext();
        if(((v0 instanceof ContextWrapper)) && (Build$VERSION.SDK_INT < 15 || (android.support.v4.h.p.n(arg4)))) {
            TypedArray v0_1 = v0.obtainStyledAttributes(arg5, m.b);
            String v1 = v0_1.getString(0);
            if(v1 != null) {
                arg4.setOnClickListener(new a(arg4, v1));
            }

            v0_1.recycle();
        }
    }
}

