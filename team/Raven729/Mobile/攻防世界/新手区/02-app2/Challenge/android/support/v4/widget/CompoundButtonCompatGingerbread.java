package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

@TargetApi(value=9) @RequiresApi(value=9) class CompoundButtonCompatGingerbread {
    private static final String TAG = "CompoundButtonCompatGingerbread";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    CompoundButtonCompatGingerbread() {
        super();
    }

    static Drawable getButtonDrawable(CompoundButton arg5) {
        Drawable v0_3;
        Field v1 = null;
        if(!CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched) {
            try {
                CompoundButtonCompatGingerbread.sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                CompoundButtonCompatGingerbread.sButtonDrawableField.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to retrieve mButtonDrawable field", ((Throwable)v0));
            }

            CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched = true;
        }

        if(CompoundButtonCompatGingerbread.sButtonDrawableField != null) {
            try {
                Object v0_2 = CompoundButtonCompatGingerbread.sButtonDrawableField.get(arg5);
                return v0_3;
            }
            catch(IllegalAccessException v0_1) {
                goto label_25;
            }
        }

    label_27:
        v0_3 = ((Drawable)v1);
        return v0_3;
    label_25:
        Log.i("CompoundButtonCompatGingerbread", "Failed to get button drawable via reflection", ((Throwable)v0_1));
        CompoundButtonCompatGingerbread.sButtonDrawableField = v1;
        goto label_27;
        return v0_3;
    }

    static ColorStateList getButtonTintList(CompoundButton arg1) {
        ColorStateList v0 = (arg1 instanceof TintableCompoundButton) ? ((TintableCompoundButton)arg1).getSupportButtonTintList() : null;
        return v0;
    }

    static PorterDuff$Mode getButtonTintMode(CompoundButton arg1) {
        PorterDuff$Mode v0 = (arg1 instanceof TintableCompoundButton) ? ((TintableCompoundButton)arg1).getSupportButtonTintMode() : null;
        return v0;
    }

    static void setButtonTintList(CompoundButton arg1, ColorStateList arg2) {
        if((arg1 instanceof TintableCompoundButton)) {
            ((TintableCompoundButton)arg1).setSupportButtonTintList(arg2);
        }
    }

    static void setButtonTintMode(CompoundButton arg1, PorterDuff$Mode arg2) {
        if((arg1 instanceof TintableCompoundButton)) {
            ((TintableCompoundButton)arg1).setSupportButtonTintMode(arg2);
        }
    }
}

