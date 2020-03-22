package android.support.v4.h;

import android.view.View;
import android.view.ViewParent;

public class j {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public j(View arg1) {
        super();
        this.c = arg1;
    }

    private void a(int arg1, ViewParent arg2) {
        switch(arg1) {
            case 0: {
                this.a = arg2;
                break;
            }
            case 1: {
                this.b = arg2;
                break;
            }
        }
    }

    public void a(boolean arg2) {
        if(this.d) {
            p.k(this.c);
        }

        this.d = arg2;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(float arg3, float arg4) {
        boolean v0 = false;
        if(this.a()) {
            ViewParent v1 = this.d(0);
            if(v1 != null) {
                v0 = q.a(v1, this.c, arg3, arg4);
            }
        }

        return v0;
    }

    public boolean a(float arg3, float arg4, boolean arg5) {
        boolean v0 = false;
        if(this.a()) {
            ViewParent v1 = this.d(0);
            if(v1 != null) {
                v0 = q.a(v1, this.c, arg3, arg4, arg5);
            }
        }

        return v0;
    }

    public boolean a(int arg2) {
        boolean v0 = this.d(arg2) != null ? true : false;
        return v0;
    }

    public boolean a(int arg5, int arg6) {
        boolean v0;
        if(this.a(arg6)) {
            v0 = true;
        }
        else {
            if(this.a()) {
                ViewParent v1 = this.c.getParent();
                View v0_1 = this.c;
                while(v1 != null) {
                    if(q.a(v1, v0_1, this.c, arg5, arg6)) {
                        this.a(arg6, v1);
                        q.b(v1, v0_1, this.c, arg5, arg6);
                        return true;
                    }
                    else {
                        if((v1 instanceof View)) {
                            ViewParent v0_2 = v1;
                        }

                        v1 = v1.getParent();
                        continue;
                    }
                }
            }

            v0 = false;
        }

        return v0;
    }

    public boolean a(int arg8, int arg9, int arg10, int arg11, int[] arg12) {
        return this.a(arg8, arg9, arg10, arg11, arg12, 0);
    }

    public boolean a(int arg10, int arg11, int arg12, int arg13, int[] arg14, int arg15) {
        int v8;
        int v7;
        boolean v0_1;
        if(this.a()) {
            ViewParent v0 = this.d(arg15);
            if(v0 == null) {
                v0_1 = false;
            }
            else {
                if(arg10 == 0 && arg11 == 0 && arg12 == 0 && arg13 == 0) {
                    if(arg14 != null) {
                        arg14[0] = 0;
                        arg14[1] = 0;
                    }
                    else {
                    }

                    goto label_48;
                }

                if(arg14 != null) {
                    this.c.getLocationInWindow(arg14);
                    int v2 = arg14[0];
                    v7 = arg14[1];
                    v8 = v2;
                }
                else {
                    v7 = 0;
                    v8 = 0;
                }

                q.a(v0, this.c, arg10, arg11, arg12, arg13, arg15);
                if(arg14 != null) {
                    this.c.getLocationInWindow(arg14);
                    arg14[0] -= v8;
                    arg14[1] -= v7;
                }

                v0_1 = true;
            }
        }
        else {
        label_48:
            v0_1 = false;
        }

        return v0_1;
    }

    public boolean a(int arg7, int arg8, int[] arg9, int[] arg10) {
        return this.a(arg7, arg8, arg9, arg10, 0);
    }

    public boolean a(int arg11, int arg12, int[] arg13, int[] arg14, int arg15) {
        int[] v4;
        int v9;
        int v8;
        boolean v6 = false;
        if(this.a()) {
            ViewParent v0 = this.d(arg15);
            if(v0 != null) {
                if(arg11 == 0 && arg12 == 0) {
                    if(arg14 != null) {
                        arg14[0] = 0;
                        arg14[1] = 0;
                    }
                    else {
                    }

                    return v6;
                }

                if(arg14 != null) {
                    this.c.getLocationInWindow(arg14);
                    int v2 = arg14[0];
                    v8 = arg14[1];
                    v9 = v2;
                }
                else {
                    v8 = 0;
                    v9 = 0;
                }

                if(arg13 == null) {
                    if(this.e == null) {
                        this.e = new int[2];
                    }

                    v4 = this.e;
                }
                else {
                    v4 = arg13;
                }

                v4[0] = 0;
                v4[1] = 0;
                q.a(v0, this.c, arg11, arg12, v4, arg15);
                if(arg14 != null) {
                    this.c.getLocationInWindow(arg14);
                    arg14[0] -= v9;
                    arg14[1] -= v8;
                }

                boolean v0_1 = v4[0] != 0 || v4[1] != 0 ? true : false;
                v6 = v0_1;
            }
        }

        return v6;
    }

    public boolean b() {
        return this.a(0);
    }

    public boolean b(int arg2) {
        return this.a(arg2, 0);
    }

    public void c() {
        this.c(0);
    }

    public void c(int arg3) {
        ViewParent v0 = this.d(arg3);
        if(v0 != null) {
            q.a(v0, this.c, arg3);
            this.a(arg3, null);
        }
    }

    private ViewParent d(int arg2) {
        ViewParent v0;
        switch(arg2) {
            case 0: {
                v0 = this.a;
                break;
            }
            case 1: {
                v0 = this.b;
                break;
            }
            default: {
                v0 = null;
                break;
            }
        }

        return v0;
    }
}

