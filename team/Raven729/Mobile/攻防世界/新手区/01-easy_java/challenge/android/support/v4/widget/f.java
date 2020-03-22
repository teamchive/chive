package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.widget.ImageView;

public class f {
    class a implements b {
        a() {
            super();
        }

        public ColorStateList a(ImageView arg2) {
            ColorStateList v0 = (arg2 instanceof l) ? ((l)arg2).getSupportImageTintList() : null;
            return v0;
        }

        public void a(ImageView arg2, ColorStateList arg3) {
            if((arg2 instanceof l)) {
                ((l)arg2).setSupportImageTintList(arg3);
            }
        }

        public void a(ImageView arg2, PorterDuff$Mode arg3) {
            if((arg2 instanceof l)) {
                ((l)arg2).setSupportImageTintMode(arg3);
            }
        }

        public PorterDuff$Mode b(ImageView arg2) {
            PorterDuff$Mode v0 = (arg2 instanceof l) ? ((l)arg2).getSupportImageTintMode() : null;
            return v0;
        }
    }

    interface b {
        ColorStateList a(ImageView arg1);

        void a(ImageView arg1, ColorStateList arg2);

        void a(ImageView arg1, PorterDuff$Mode arg2);

        PorterDuff$Mode b(ImageView arg1);
    }

    class c extends a {
        c() {
            super();
        }

        public ColorStateList a(ImageView arg2) {
            return arg2.getImageTintList();
        }

        public void a(ImageView arg3, ColorStateList arg4) {
            arg3.setImageTintList(arg4);
            if(Build$VERSION.SDK_INT == 21) {
                Drawable v1 = arg3.getDrawable();
                int v0 = arg3.getImageTintList() == null || arg3.getImageTintMode() == null ? 0 : 1;
                if(v1 == null) {
                    return;
                }

                if(v0 == 0) {
                    return;
                }

                if(v1.isStateful()) {
                    v1.setState(arg3.getDrawableState());
                }

                arg3.setImageDrawable(v1);
            }
        }

        public void a(ImageView arg3, PorterDuff$Mode arg4) {
            arg3.setImageTintMode(arg4);
            if(Build$VERSION.SDK_INT == 21) {
                Drawable v1 = arg3.getDrawable();
                int v0 = arg3.getImageTintList() == null || arg3.getImageTintMode() == null ? 0 : 1;
                if(v1 == null) {
                    return;
                }

                if(v0 == 0) {
                    return;
                }

                if(v1.isStateful()) {
                    v1.setState(arg3.getDrawableState());
                }

                arg3.setImageDrawable(v1);
            }
        }

        public PorterDuff$Mode b(ImageView arg2) {
            return arg2.getImageTintMode();
        }
    }

    static final b a;

    static {
        f.a = Build$VERSION.SDK_INT >= 21 ? new c() : new a();
    }

    public static ColorStateList a(ImageView arg1) {
        return f.a.a(arg1);
    }

    public static void a(ImageView arg1, ColorStateList arg2) {
        f.a.a(arg1, arg2);
    }

    public static void a(ImageView arg1, PorterDuff$Mode arg2) {
        f.a.a(arg1, arg2);
    }

    public static PorterDuff$Mode b(ImageView arg1) {
        return f.a.b(arg1);
    }
}

