package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class DrawableCompat {
    class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
            super();
        }

        public void applyTheme(Drawable arg1, Resources$Theme arg2) {
        }

        public boolean canApplyTheme(Drawable arg2) {
            return 0;
        }

        public void clearColorFilter(Drawable arg1) {
            arg1.clearColorFilter();
        }

        public int getAlpha(Drawable arg2) {
            return 0;
        }

        public ColorFilter getColorFilter(Drawable arg2) {
            return null;
        }

        public int getLayoutDirection(Drawable arg2) {
            return 0;
        }

        public void inflate(Drawable arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
            DrawableCompatBase.inflate(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean isAutoMirrored(Drawable arg2) {
            return 0;
        }

        public void jumpToCurrentState(Drawable arg1) {
        }

        public void setAutoMirrored(Drawable arg1, boolean arg2) {
        }

        public void setHotspot(Drawable arg1, float arg2, float arg3) {
        }

        public void setHotspotBounds(Drawable arg1, int arg2, int arg3, int arg4, int arg5) {
        }

        public boolean setLayoutDirection(Drawable arg2, int arg3) {
            return 0;
        }

        public void setTint(Drawable arg1, int arg2) {
            DrawableCompatBase.setTint(arg1, arg2);
        }

        public void setTintList(Drawable arg1, ColorStateList arg2) {
            DrawableCompatBase.setTintList(arg1, arg2);
        }

        public void setTintMode(Drawable arg1, PorterDuff$Mode arg2) {
            DrawableCompatBase.setTintMode(arg1, arg2);
        }

        public Drawable wrap(Drawable arg2) {
            return DrawableCompatBase.wrapForTinting(arg2);
        }
    }

    interface DrawableImpl {
        void applyTheme(Drawable arg1, Resources$Theme arg2);

        boolean canApplyTheme(Drawable arg1);

        void clearColorFilter(Drawable arg1);

        int getAlpha(Drawable arg1);

        ColorFilter getColorFilter(Drawable arg1);

        int getLayoutDirection(Drawable arg1);

        void inflate(Drawable arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5);

        boolean isAutoMirrored(Drawable arg1);

        void jumpToCurrentState(Drawable arg1);

        void setAutoMirrored(Drawable arg1, boolean arg2);

        void setHotspot(Drawable arg1, float arg2, float arg3);

        void setHotspotBounds(Drawable arg1, int arg2, int arg3, int arg4, int arg5);

        boolean setLayoutDirection(Drawable arg1, int arg2);

        void setTint(Drawable arg1, int arg2);

        void setTintList(Drawable arg1, ColorStateList arg2);

        void setTintMode(Drawable arg1, PorterDuff$Mode arg2);

        Drawable wrap(Drawable arg1);
    }

    class HoneycombDrawableImpl extends BaseDrawableImpl {
        HoneycombDrawableImpl() {
            super();
        }

        public void jumpToCurrentState(Drawable arg1) {
            DrawableCompatHoneycomb.jumpToCurrentState(arg1);
        }

        public Drawable wrap(Drawable arg2) {
            return DrawableCompatHoneycomb.wrapForTinting(arg2);
        }
    }

    class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
        JellybeanMr1DrawableImpl() {
            super();
        }

        public int getLayoutDirection(Drawable arg2) {
            int v0 = DrawableCompatJellybeanMr1.getLayoutDirection(arg2);
            if(v0 < 0) {
                v0 = 0;
            }

            return v0;
        }

        public boolean setLayoutDirection(Drawable arg2, int arg3) {
            return DrawableCompatJellybeanMr1.setLayoutDirection(arg2, arg3);
        }
    }

    class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
        KitKatDrawableImpl() {
            super();
        }

        public int getAlpha(Drawable arg2) {
            return DrawableCompatKitKat.getAlpha(arg2);
        }

        public boolean isAutoMirrored(Drawable arg2) {
            return DrawableCompatKitKat.isAutoMirrored(arg2);
        }

        public void setAutoMirrored(Drawable arg1, boolean arg2) {
            DrawableCompatKitKat.setAutoMirrored(arg1, arg2);
        }

        public Drawable wrap(Drawable arg2) {
            return DrawableCompatKitKat.wrapForTinting(arg2);
        }
    }

    class LollipopDrawableImpl extends KitKatDrawableImpl {
        LollipopDrawableImpl() {
            super();
        }

        public void applyTheme(Drawable arg1, Resources$Theme arg2) {
            DrawableCompatLollipop.applyTheme(arg1, arg2);
        }

        public boolean canApplyTheme(Drawable arg2) {
            return DrawableCompatLollipop.canApplyTheme(arg2);
        }

        public void clearColorFilter(Drawable arg1) {
            DrawableCompatLollipop.clearColorFilter(arg1);
        }

        public ColorFilter getColorFilter(Drawable arg2) {
            return DrawableCompatLollipop.getColorFilter(arg2);
        }

        public void inflate(Drawable arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
            DrawableCompatLollipop.inflate(arg1, arg2, arg3, arg4, arg5);
        }

        public void setHotspot(Drawable arg1, float arg2, float arg3) {
            DrawableCompatLollipop.setHotspot(arg1, arg2, arg3);
        }

        public void setHotspotBounds(Drawable arg1, int arg2, int arg3, int arg4, int arg5) {
            DrawableCompatLollipop.setHotspotBounds(arg1, arg2, arg3, arg4, arg5);
        }

        public void setTint(Drawable arg1, int arg2) {
            DrawableCompatLollipop.setTint(arg1, arg2);
        }

        public void setTintList(Drawable arg1, ColorStateList arg2) {
            DrawableCompatLollipop.setTintList(arg1, arg2);
        }

        public void setTintMode(Drawable arg1, PorterDuff$Mode arg2) {
            DrawableCompatLollipop.setTintMode(arg1, arg2);
        }

        public Drawable wrap(Drawable arg2) {
            return DrawableCompatLollipop.wrapForTinting(arg2);
        }
    }

    class MDrawableImpl extends LollipopDrawableImpl {
        MDrawableImpl() {
            super();
        }

        public void clearColorFilter(Drawable arg1) {
            arg1.clearColorFilter();
        }

        public int getLayoutDirection(Drawable arg2) {
            return DrawableCompatApi23.getLayoutDirection(arg2);
        }

        public boolean setLayoutDirection(Drawable arg2, int arg3) {
            return DrawableCompatApi23.setLayoutDirection(arg2, arg3);
        }

        public Drawable wrap(Drawable arg1) {
            return arg1;
        }
    }

    static final DrawableImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 23) {
            DrawableCompat.IMPL = new MDrawableImpl();
        }
        else if(v0 >= 21) {
            DrawableCompat.IMPL = new LollipopDrawableImpl();
        }
        else if(v0 >= 19) {
            DrawableCompat.IMPL = new KitKatDrawableImpl();
        }
        else if(v0 >= 17) {
            DrawableCompat.IMPL = new JellybeanMr1DrawableImpl();
        }
        else if(v0 >= 11) {
            DrawableCompat.IMPL = new HoneycombDrawableImpl();
        }
        else {
            DrawableCompat.IMPL = new BaseDrawableImpl();
        }
    }

    private DrawableCompat() {
        super();
    }

    public static void applyTheme(@NonNull Drawable arg1, @NonNull Resources$Theme arg2) {
        DrawableCompat.IMPL.applyTheme(arg1, arg2);
    }

    public static boolean canApplyTheme(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.canApplyTheme(arg1);
    }

    public static void clearColorFilter(@NonNull Drawable arg1) {
        DrawableCompat.IMPL.clearColorFilter(arg1);
    }

    public static int getAlpha(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.getAlpha(arg1);
    }

    public static ColorFilter getColorFilter(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.getColorFilter(arg1);
    }

    public static int getLayoutDirection(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.getLayoutDirection(arg1);
    }

    public static void inflate(@NonNull Drawable arg6, @NonNull Resources arg7, @NonNull XmlPullParser arg8, @NonNull AttributeSet arg9, @Nullable Resources$Theme arg10) {
        DrawableCompat.IMPL.inflate(arg6, arg7, arg8, arg9, arg10);
    }

    public static boolean isAutoMirrored(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.isAutoMirrored(arg1);
    }

    public static void jumpToCurrentState(@NonNull Drawable arg1) {
        DrawableCompat.IMPL.jumpToCurrentState(arg1);
    }

    public static void setAutoMirrored(@NonNull Drawable arg1, boolean arg2) {
        DrawableCompat.IMPL.setAutoMirrored(arg1, arg2);
    }

    public static void setHotspot(@NonNull Drawable arg1, float arg2, float arg3) {
        DrawableCompat.IMPL.setHotspot(arg1, arg2, arg3);
    }

    public static void setHotspotBounds(@NonNull Drawable arg6, int arg7, int arg8, int arg9, int arg10) {
        DrawableCompat.IMPL.setHotspotBounds(arg6, arg7, arg8, arg9, arg10);
    }

    public static boolean setLayoutDirection(@NonNull Drawable arg1, int arg2) {
        return DrawableCompat.IMPL.setLayoutDirection(arg1, arg2);
    }

    public static void setTint(@NonNull Drawable arg1, @ColorInt int arg2) {
        DrawableCompat.IMPL.setTint(arg1, arg2);
    }

    public static void setTintList(@NonNull Drawable arg1, @Nullable ColorStateList arg2) {
        DrawableCompat.IMPL.setTintList(arg1, arg2);
    }

    public static void setTintMode(@NonNull Drawable arg1, @Nullable PorterDuff$Mode arg2) {
        DrawableCompat.IMPL.setTintMode(arg1, arg2);
    }

    public static Drawable unwrap(@NonNull Drawable arg1) {
        if((arg1 instanceof DrawableWrapper)) {
            arg1 = ((DrawableWrapper)arg1).getWrappedDrawable();
        }

        return arg1;
    }

    public static Drawable wrap(@NonNull Drawable arg1) {
        return DrawableCompat.IMPL.wrap(arg1);
    }
}

