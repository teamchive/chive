package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class b {
    class a extends c {
        a() {
            super();
        }

        public void a(CompoundButton arg1, ColorStateList arg2) {
            arg1.setButtonTintList(arg2);
        }

        public void a(CompoundButton arg1, PorterDuff$Mode arg2) {
            arg1.setButtonTintMode(arg2);
        }
    }

    class android.support.v4.widget.b$b extends a {
        android.support.v4.widget.b$b() {
            super();
        }

        public Drawable a(CompoundButton arg2) {
            return arg2.getButtonDrawable();
        }
    }

    class c {
        private static Field a;
        private static boolean b;

        c() {
            super();
        }

        public Drawable a(CompoundButton arg6) {
            Object v0_2;
            Field v1 = null;
            if(!c.b) {
                try {
                    c.a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    c.a.setAccessible(true);
                }
                catch(NoSuchFieldException v0) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", ((Throwable)v0));
                }

                c.b = true;
            }

            if(c.a != null) {
                try {
                    v0_2 = c.a.get(arg6);
                    goto label_16;
                }
                catch(IllegalAccessException v0_1) {
                    goto label_25;
                }
            }

        label_27:
            Drawable v0_3 = ((Drawable)v1);
            goto label_16;
        label_25:
            Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", ((Throwable)v0_1));
            c.a = v1;
            goto label_27;
        label_16:
            return ((Drawable)v0_2);
        }

        public void a(CompoundButton arg2, ColorStateList arg3) {
            if((arg2 instanceof k)) {
                ((k)arg2).setSupportButtonTintList(arg3);
            }
        }

        public void a(CompoundButton arg2, PorterDuff$Mode arg3) {
            if((arg2 instanceof k)) {
                ((k)arg2).setSupportButtonTintMode(arg3);
            }
        }
    }

    private static final c a;

    static {
        if(Build$VERSION.SDK_INT >= 23) {
            b.a = new android.support.v4.widget.b$b();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            b.a = new a();
        }
        else {
            b.a = new c();
        }
    }

    public static Drawable a(CompoundButton arg1) {
        return b.a.a(arg1);
    }

    public static void a(CompoundButton arg1, ColorStateList arg2) {
        b.a.a(arg1, arg2);
    }

    public static void a(CompoundButton arg1, PorterDuff$Mode arg2) {
        b.a.a(arg1, arg2);
    }
}

