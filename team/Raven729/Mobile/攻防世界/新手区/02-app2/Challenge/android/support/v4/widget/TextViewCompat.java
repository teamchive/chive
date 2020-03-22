package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.widget.TextView;

public final class TextViewCompat {
    class Api23TextViewCompatImpl extends JbMr2TextViewCompatImpl {
        Api23TextViewCompatImpl() {
            super();
        }

        public void setTextAppearance(@NonNull TextView arg1, @StyleRes int arg2) {
            TextViewCompatApi23.setTextAppearance(arg1, arg2);
        }
    }

    class BaseTextViewCompatImpl implements TextViewCompatImpl {
        BaseTextViewCompatImpl() {
            super();
        }

        public Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg2) {
            return TextViewCompatGingerbread.getCompoundDrawablesRelative(arg2);
        }

        public int getMaxLines(TextView arg2) {
            return TextViewCompatGingerbread.getMaxLines(arg2);
        }

        public int getMinLines(TextView arg2) {
            return TextViewCompatGingerbread.getMinLines(arg2);
        }

        public void setCompoundDrawablesRelative(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            arg1.setCompoundDrawables(arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @DrawableRes int arg2, @DrawableRes int arg3, @DrawableRes int arg4, @DrawableRes int arg5) {
            arg1.setCompoundDrawablesWithIntrinsicBounds(arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            arg1.setCompoundDrawablesWithIntrinsicBounds(arg2, arg3, arg4, arg5);
        }

        public void setTextAppearance(TextView arg1, @StyleRes int arg2) {
            TextViewCompatGingerbread.setTextAppearance(arg1, arg2);
        }
    }

    class JbMr1TextViewCompatImpl extends JbTextViewCompatImpl {
        JbMr1TextViewCompatImpl() {
            super();
        }

        public Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg2) {
            return TextViewCompatJbMr1.getCompoundDrawablesRelative(arg2);
        }

        public void setCompoundDrawablesRelative(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            TextViewCompatJbMr1.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @DrawableRes int arg2, @DrawableRes int arg3, @DrawableRes int arg4, @DrawableRes int arg5) {
            TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4, arg5);
        }
    }

    class JbMr2TextViewCompatImpl extends JbMr1TextViewCompatImpl {
        JbMr2TextViewCompatImpl() {
            super();
        }

        public Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg2) {
            return TextViewCompatJbMr2.getCompoundDrawablesRelative(arg2);
        }

        public void setCompoundDrawablesRelative(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            TextViewCompatJbMr2.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @DrawableRes int arg2, @DrawableRes int arg3, @DrawableRes int arg4, @DrawableRes int arg5) {
            TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4, arg5);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5) {
            TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4, arg5);
        }
    }

    class JbTextViewCompatImpl extends BaseTextViewCompatImpl {
        JbTextViewCompatImpl() {
            super();
        }

        public int getMaxLines(TextView arg2) {
            return TextViewCompatJb.getMaxLines(arg2);
        }

        public int getMinLines(TextView arg2) {
            return TextViewCompatJb.getMinLines(arg2);
        }
    }

    interface TextViewCompatImpl {
        Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg1);

        int getMaxLines(TextView arg1);

        int getMinLines(TextView arg1);

        void setCompoundDrawablesRelative(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5);

        void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @DrawableRes int arg2, @DrawableRes int arg3, @DrawableRes int arg4, @DrawableRes int arg5);

        void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5);

        void setTextAppearance(@NonNull TextView arg1, @StyleRes int arg2);
    }

    static final TextViewCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 23) {
            TextViewCompat.IMPL = new Api23TextViewCompatImpl();
        }
        else if(v0 >= 18) {
            TextViewCompat.IMPL = new JbMr2TextViewCompatImpl();
        }
        else if(v0 >= 17) {
            TextViewCompat.IMPL = new JbMr1TextViewCompatImpl();
        }
        else if(v0 >= 16) {
            TextViewCompat.IMPL = new JbTextViewCompatImpl();
        }
        else {
            TextViewCompat.IMPL = new BaseTextViewCompatImpl();
        }
    }

    private TextViewCompat() {
        super();
    }

    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg1) {
        return TextViewCompat.IMPL.getCompoundDrawablesRelative(arg1);
    }

    public static int getMaxLines(@NonNull TextView arg1) {
        return TextViewCompat.IMPL.getMaxLines(arg1);
    }

    public static int getMinLines(@NonNull TextView arg1) {
        return TextViewCompat.IMPL.getMinLines(arg1);
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView arg6, @Nullable Drawable arg7, @Nullable Drawable arg8, @Nullable Drawable arg9, @Nullable Drawable arg10) {
        TextViewCompat.IMPL.setCompoundDrawablesRelative(arg6, arg7, arg8, arg9, arg10);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg6, @DrawableRes int arg7, @DrawableRes int arg8, @DrawableRes int arg9, @DrawableRes int arg10) {
        TextViewCompat.IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(arg6, arg7, arg8, arg9, arg10);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg6, @Nullable Drawable arg7, @Nullable Drawable arg8, @Nullable Drawable arg9, @Nullable Drawable arg10) {
        TextViewCompat.IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(arg6, arg7, arg8, arg9, arg10);
    }

    public static void setTextAppearance(@NonNull TextView arg1, @StyleRes int arg2) {
        TextViewCompat.IMPL.setTextAppearance(arg1, arg2);
    }
}

