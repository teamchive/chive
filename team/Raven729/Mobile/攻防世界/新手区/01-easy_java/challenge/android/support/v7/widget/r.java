package android.support.v7.widget;

import android.content.Context;
import android.os.Build$VERSION;
import android.support.v4.widget.i;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

class r extends PopupWindow {
    private static final boolean a;
    private boolean b;

    static {
        boolean v0 = Build$VERSION.SDK_INT < 21 ? true : false;
        r.a = v0;
    }

    public r(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.a(arg1, arg2, arg3, arg4);
    }

    private void a(Context arg4, AttributeSet arg5, int arg6, int arg7) {
        aw v0 = aw.a(arg4, arg5, j.PopupWindow, arg6, arg7);
        if(v0.g(j.PopupWindow_overlapAnchor)) {
            this.a(v0.a(j.PopupWindow_overlapAnchor, false));
        }

        this.setBackgroundDrawable(v0.a(j.PopupWindow_android_popupBackground));
        int v1 = Build$VERSION.SDK_INT;
        if(arg7 != 0 && v1 < 11 && (v0.g(j.PopupWindow_android_popupAnimationStyle))) {
            this.setAnimationStyle(v0.g(j.PopupWindow_android_popupAnimationStyle, -1));
        }

        v0.a();
        if(Build$VERSION.SDK_INT < 14) {
            r.a(((PopupWindow)this));
        }
    }

    public void a(boolean arg2) {
        if(r.a) {
            this.b = arg2;
        }
        else {
            i.a(((PopupWindow)this), arg2);
        }
    }

    private static void a(PopupWindow arg4) {
        try {
            Field v1 = PopupWindow.class.getDeclaredField("mAnchor");
            v1.setAccessible(true);
            Field v2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            v2.setAccessible(true);
            v2.set(arg4, new ViewTreeObserver$OnScrollChangedListener(v1, arg4, v2.get(arg4)) {
                public void onScrollChanged() {
                    try {
                        Object v0_1 = this.a.get(this.b);
                        if(v0_1 == null) {
                            return;
                        }

                        if(((WeakReference)v0_1).get() == null) {
                            return;
                        }

                        this.c.onScrollChanged();
                    }
                    catch(IllegalAccessException v0) {
                    }
                }
            });
        }
        catch(Exception v0) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", ((Throwable)v0));
        }
    }

    public void showAsDropDown(View arg2, int arg3, int arg4) {
        if((r.a) && (this.b)) {
            arg4 -= arg2.getHeight();
        }

        super.showAsDropDown(arg2, arg3, arg4);
    }

    public void showAsDropDown(View arg2, int arg3, int arg4, int arg5) {
        if((r.a) && (this.b)) {
            arg4 -= arg2.getHeight();
        }

        super.showAsDropDown(arg2, arg3, arg4, arg5);
    }

    public void update(View arg7, int arg8, int arg9, int arg10, int arg11) {
        int v3 = !r.a || !this.b ? arg9 : arg9 - arg7.getHeight();
        super.update(arg7, arg8, v3, arg10, arg11);
    }
}

