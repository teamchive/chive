package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
    class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
            super();
        }

        public Drawable getButtonDrawable(CompoundButton arg2) {
            return CompoundButtonCompatApi23.getButtonDrawable(arg2);
        }
    }

    class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
            super();
        }

        public Drawable getButtonDrawable(CompoundButton arg2) {
            return CompoundButtonCompatGingerbread.getButtonDrawable(arg2);
        }

        public ColorStateList getButtonTintList(CompoundButton arg2) {
            return CompoundButtonCompatGingerbread.getButtonTintList(arg2);
        }

        public PorterDuff$Mode getButtonTintMode(CompoundButton arg2) {
            return CompoundButtonCompatGingerbread.getButtonTintMode(arg2);
        }

        public void setButtonTintList(CompoundButton arg1, ColorStateList arg2) {
            CompoundButtonCompatGingerbread.setButtonTintList(arg1, arg2);
        }

        public void setButtonTintMode(CompoundButton arg1, PorterDuff$Mode arg2) {
            CompoundButtonCompatGingerbread.setButtonTintMode(arg1, arg2);
        }
    }

    interface CompoundButtonCompatImpl {
        Drawable getButtonDrawable(CompoundButton arg1);

        ColorStateList getButtonTintList(CompoundButton arg1);

        PorterDuff$Mode getButtonTintMode(CompoundButton arg1);

        void setButtonTintList(CompoundButton arg1, ColorStateList arg2);

        void setButtonTintMode(CompoundButton arg1, PorterDuff$Mode arg2);
    }

    class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
            super();
        }

        public ColorStateList getButtonTintList(CompoundButton arg2) {
            return CompoundButtonCompatLollipop.getButtonTintList(arg2);
        }

        public PorterDuff$Mode getButtonTintMode(CompoundButton arg2) {
            return CompoundButtonCompatLollipop.getButtonTintMode(arg2);
        }

        public void setButtonTintList(CompoundButton arg1, ColorStateList arg2) {
            CompoundButtonCompatLollipop.setButtonTintList(arg1, arg2);
        }

        public void setButtonTintMode(CompoundButton arg1, PorterDuff$Mode arg2) {
            CompoundButtonCompatLollipop.setButtonTintMode(arg1, arg2);
        }
    }

    private static final CompoundButtonCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 23) {
            CompoundButtonCompat.IMPL = new Api23CompoundButtonImpl();
        }
        else if(v0 >= 21) {
            CompoundButtonCompat.IMPL = new LollipopCompoundButtonImpl();
        }
        else {
            CompoundButtonCompat.IMPL = new BaseCompoundButtonCompat();
        }
    }

    private CompoundButtonCompat() {
        super();
    }

    @Nullable public static Drawable getButtonDrawable(@NonNull CompoundButton arg1) {
        return CompoundButtonCompat.IMPL.getButtonDrawable(arg1);
    }

    @Nullable public static ColorStateList getButtonTintList(@NonNull CompoundButton arg1) {
        return CompoundButtonCompat.IMPL.getButtonTintList(arg1);
    }

    @Nullable public static PorterDuff$Mode getButtonTintMode(@NonNull CompoundButton arg1) {
        return CompoundButtonCompat.IMPL.getButtonTintMode(arg1);
    }

    public static void setButtonTintList(@NonNull CompoundButton arg1, @Nullable ColorStateList arg2) {
        CompoundButtonCompat.IMPL.setButtonTintList(arg1, arg2);
    }

    public static void setButtonTintMode(@NonNull CompoundButton arg1, @Nullable PorterDuff$Mode arg2) {
        CompoundButtonCompat.IMPL.setButtonTintMode(arg1, arg2);
    }
}

